package com.sevilladeux.StockMarketMonitor.rest;

import com.fasterxml.jackson.databind.*;
import com.sevilladeux.StockMarketMonitor.common.Constants;
import com.sevilladeux.StockMarketMonitor.rest.models.Stock;
import com.sevilladeux.StockMarketMonitor.rest.models.StockRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class StockServiceImpl implements StockService{

    public ConcurrentHashMap<String, Stock> stockCache = new ConcurrentHashMap<>();

    public List<String> fetchStockSymbolsInMemory() {
        List<String> listOfSymbols = new ArrayList<>();
        for(Map.Entry<String, Stock> item : stockCache.entrySet()){
            listOfSymbols.add(item.getKey());
        }
        return listOfSymbols;
    }


    public Stock getStockTimeSeries(StockRequest stockRequest)
    {
        System.out.printf("===== Getting Stock Time Series Data for '%s' =====\n", stockRequest.getSymbol());

        if(stockCache.containsKey(stockRequest.getSymbol())){
          // only return stock if it has not expired
            long expirationTime = stockCache.get(stockRequest.getSymbol()).getExpiration();
            if (System.currentTimeMillis() <= expirationTime){
                System.out.printf("Found '%s' in cache\n", stockRequest.getSymbol());
                System.out.printf("===== Retrieved Stock Time Series Data for '%s' =====\n", stockRequest.getSymbol());
                return stockCache.get(stockRequest.getSymbol());
            }
            else{
                // evict it from the cache and move on
                stockCache.remove(stockRequest.getSymbol());
                System.out.printf("Evicted '%s' from the cache\n", stockRequest.getSymbol());
            }
        }
        HttpResponse<String> response = requestGetStockTimeSeries(stockRequest);

        // Now I have to map the item into memory
        Stock stock = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try{
            stock = objectMapper.readValue(response.body(), Stock.class);
            stock.setExpiration(Constants.generateExpirationTimeInMillis());
            stockCache.put(stockRequest.getSymbol(), stock);
            System.out.printf("Added a '%s' to the stockCache...\n", stockRequest.getSymbol());
            System.out.printf("===== Retrieved Stock Time Series Data for '%s' =====\n", stockRequest.getSymbol());
        } catch(Exception e){
            System.out.printf("Failed to store response body in memory: %s", e);
            e.printStackTrace();
        }
        return stock;
    }

    /**
     * This function is responsible for making the API call to the alpha vantage API
     * based on the stockRequest that was made.
     * @param stockRequest : contains the information required to 
     * @return response from the alpha vantage API time series
     */
    private HttpResponse<String> requestGetStockTimeSeries(StockRequest stockRequest)
    {
        String endpoint = "https://alpha-vantage.p.rapidapi.com/query?symbol=" + stockRequest.getSymbol()
                + "&function=" + stockRequest.getFunction()
                + "&interval=" + stockRequest.getInterval()
                + "&output_size=" +stockRequest.getOutputSize() + "&datatype=json";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("X-RapidAPI-Key", Constants.API_KEY)
                .header("X-RapidAPI-Host", Constants.API_HOST)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
        return response;
    }


    /**
     * This function will prune expired stocks from the stockCache
     */
    public void pruneExpiredStocks(){
        int prunedExpiredStocksCount = 0;

        for (Map.Entry<String, Stock> stock : stockCache.entrySet())
        {
            long expiredTime = stock.getValue().getExpiration();
            if (System.currentTimeMillis() > expiredTime){
                stockCache.remove(stock.getValue().getMetaData().getSymbol());
                prunedExpiredStocksCount++;
            }
        }

        System.out.printf("pruneExpiredStocks pruned '%d' stocks from stockCache\n", prunedExpiredStocksCount);
    }

}
