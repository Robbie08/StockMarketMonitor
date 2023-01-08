package com.sevilladeux.StockMarketMonitor.rest;





import com.sevilladeux.StockMarketMonitor.rest.models.MetaData;
import com.sevilladeux.StockMarketMonitor.rest.models.Stock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

public class StockServiceTest {

    @Test
    public void fetchStockSymbolsInMemoryTest()
    {
        ConcurrentHashMap<String, Stock> stockCache = new ConcurrentHashMap<>();

        stockCache.clear();
        // let's add some values to the map
        Stock tdc = new Stock();
        Stock msft = new Stock();
        Stock amzn = new Stock();

        tdc.setMetaData(new MetaData("Teradata inc",
                "TDC", "n/a", "n/a",
                "n/a", "n/a"));
        msft.setMetaData(new MetaData("Microsoft",
                "MSFT", "n/a", "n/a",
                "n/a", "n/a"));
        amzn.setMetaData(new MetaData("Amazon",
                "AMZN", "n/a", "n/a",
                "n/a", "n/a"));

        stockCache.put("TDC", tdc);
        stockCache.put("MSFT", msft);
        stockCache.put("AMZN", amzn);

        Assertions.assertTrue(stockCache.containsKey("TDC"));
        Assertions.assertTrue(stockCache.containsKey("MSFT"));
        Assertions.assertTrue(stockCache.containsKey("AMZN"));
        Assertions.assertEquals("Teradata inc", stockCache.get("TDC").getMetaData().getInformation());
        Assertions.assertEquals("Microsoft", stockCache.get("MSFT").getMetaData().getInformation());
        Assertions.assertEquals("Amazon", stockCache.get("AMZN").getMetaData().getInformation());

    }
}
