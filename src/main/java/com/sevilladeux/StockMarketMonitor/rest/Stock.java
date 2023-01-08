package com.sevilladeux.StockMarketMonitor.rest;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Stock {
    private MetaData metaData;
    private TimeSeries timeSeries;

    public MetaData getMetaData() {
        return metaData;
    }

    @JsonSetter("Meta Data")
    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public TimeSeries getTimeSeries() {
        return timeSeries;
    }

    @JsonSetter("Time Series (60min)")
    public void setTimeSeries(TimeSeries timeSeries) {
        this.timeSeries = timeSeries;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "metaData=" + metaData +
                ", timeSeries=" + timeSeries +
                '}';
    }
}
