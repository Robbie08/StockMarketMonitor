package com.sevilladeux.StockMarketMonitor.rest;

import com.sevilladeux.StockMarketMonitor.rest.models.Stock;
import com.sevilladeux.StockMarketMonitor.rest.models.StockRequest;

import java.util.List;

public interface StockService {

    /**
     * Retrieves the time series data from the AlphaVantageAPI
     * @param stockRequest the request submitted by the user
     * @return time series data as a Stock object
     */
    Stock getStockTimeSeries(StockRequest stockRequest);


    /**
     * Retrieves a list with the stocks saved in memory
     * @return a list of names for the companies in memory
     */
    List<String> fetchStockSymbolsInMemory();


    /**
     * Removes expired stock from the stockCache
     */
    void pruneExpiredStocks();
}
