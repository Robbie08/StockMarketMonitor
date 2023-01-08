package com.sevilladeux.StockMarketMonitor.rest;

import com.fasterxml.jackson.annotation.JsonSetter;

public class MetaData {
    private String information;
    private String symbol;
    private String lastRefreshed;
    private String interval;
    private String outputSize;
    private String timeZone;


    public String getInformation() {
        return information;
    }

    @JsonSetter("1. Information")
    public void setInformation(String information) {
        this.information = information;
    }

    public String getSymbol() {
        return symbol;
    }

    @JsonSetter("2. Symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    @JsonSetter("3. Last Refreshed")
    public void setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public String getInterval() {
        return interval;
    }
    @JsonSetter("4. Interval")
    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getOutputSize() {
        return outputSize;
    }

    @JsonSetter("5. Output Size")
    public void setOutputSize(String outputSize) {
        this.outputSize = outputSize;
    }

    public String getTimeZone() {
        return timeZone;
    }

    @JsonSetter("6. Time Zone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "information='" + information + '\'' +
                ", symbol='" + symbol + '\'' +
                ", lastRefreshed='" + lastRefreshed + '\'' +
                ", interval='" + interval + '\'' +
                ", outputSize='" + outputSize + '\'' +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}
