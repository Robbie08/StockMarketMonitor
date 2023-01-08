package com.sevilladeux.StockMarketMonitor.rest.models;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.sevilladeux.StockMarketMonitor.rest.models.MetaData;
import com.sevilladeux.StockMarketMonitor.rest.models.TimeSeries;

public class Stock {
    private MetaData metaData;
    private TimeSeries timeSeries;
    private long expiration;

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

    public long getExpiration(){
        return expiration;
    }

    public void setExpiration(long expiration){
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "metaData=" + metaData +
                ", timeSeries=" + timeSeries +
                '}';
    }
}
