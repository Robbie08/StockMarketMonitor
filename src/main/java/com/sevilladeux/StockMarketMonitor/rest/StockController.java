package com.sevilladeux.StockMarketMonitor.rest;

import com.sevilladeux.StockMarketMonitor.rest.models.Stock;
import com.sevilladeux.StockMarketMonitor.rest.models.StockRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) { this.stockService = stockService; }

    @RequestMapping(path="api/v1/stock/timeseries")
    @GetMapping
    public Stock getStockTimeSeries(@RequestBody StockRequest stockRequest)
    {
        // validate that all fields are included
        if (stockRequest.getSymbol().isEmpty() || stockRequest.getInterval().isEmpty() ||
                stockRequest.getOutputSize().isEmpty() || stockRequest.getFunction().isEmpty())
        {
            throw new IllegalArgumentException("The following are required in the request body:" +
                    " \"symbol\", \"interval\", \"outputSize\", and \"function\"");
        }

        // validate that the stock length is between 1-5 characters
        if(stockRequest.getSymbol().length() > 5)
        {
            throw new IllegalArgumentException("The stock symbol length must be between 1 to 5 characters");
        }

        if(!stockRequest.getInterval().contains("min"))
        {
            throw new IllegalArgumentException("The interval must be in this format <TimeInMinutes>min");
        }

        return stockService.getStockTimeSeries(stockRequest);
    }

    @RequestMapping(path="api/v1/stock/getallsymbols")
    @GetMapping
    public String getAllSymbols(){
        List<String> symbols = stockService.fetchStockSymbolsInMemory();
        for (String symbol : symbols){
            System.out.println("Stock: " +symbol);
        }
        return symbols.toString();
    }
}
