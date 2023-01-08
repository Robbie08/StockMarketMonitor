package com.sevilladeux.StockMarketMonitor.rest;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.*;

public class TimeSeries {

    private Map<String, PriceData> timeSeriesData = new TreeMap<>();

    public Map<String, PriceData> getTimeSeriesData() {
        return this.timeSeriesData;
    }

    @JsonAnySetter
    public void setTimeSeriesData(String date, PriceData priceData) {
        priceData.setTimeStamp(date);
        this.timeSeriesData.put(date, priceData);
    }

    @Override
    public String toString() {
        return "TimeSeries{" +
                timeSeriesData +
                '}';
    }
}
