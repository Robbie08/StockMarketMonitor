package com.sevilladeux.StockMarketMonitor.common;

import com.sevilladeux.StockMarketMonitor.rest.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    private final StockService stockService;

    @Autowired
    public ScheduledTasks(StockService stockService) {
        this.stockService = stockService;
    }

    /**
     * This periodic function executes every hour
     */
    @Scheduled(cron="0 0 0/1 1/1 * ?")
    public void hourlyPeriodicJob(){
        System.out.println("Running periodic Job - " + dateFormat.format(new Date()));
        System.out.println("Executing stockService.pruneExpiredStocks()...");
        stockService.pruneExpiredStocks();
    }
}
