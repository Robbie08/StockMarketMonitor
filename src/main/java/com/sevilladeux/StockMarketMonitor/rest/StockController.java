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
        return stockService.getStockTimeSeries(stockRequest);
    }

    @RequestMapping(path="api/v1/stock/getallsymbols")
    @GetMapping
    public void getAllSymbols(){
        List<String> symbols = stockService.fetchStockSymbolsInMemory();
        for (String symbol : symbols){
            System.out.println("Stock: " +symbol);
        }
    }
}
