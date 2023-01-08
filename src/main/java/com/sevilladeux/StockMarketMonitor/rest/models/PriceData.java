package com.sevilladeux.StockMarketMonitor.rest.models;

import com.fasterxml.jackson.annotation.JsonSetter;

public class PriceData {
    private String timeStamp;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;


    public String getOpen() {
        return open;
    }

    @JsonSetter("1. open")
    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    @JsonSetter("2. high")
    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    @JsonSetter("3. low")
    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    @JsonSetter("4. close")
    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    @JsonSetter("5. volume")
    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setTimeStamp(String timeStamp){
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return  this.timeStamp + " {" +
                "open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}
