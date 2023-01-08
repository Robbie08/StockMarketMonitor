package com.sevilladeux.StockMarketMonitor.rest;

public class StockRequest {
    private String symbol;
    private String interval;
    private String outputSize;
    private String function;

    public StockRequest(){}

    public StockRequest(String symbol, String interval, String outputSize, String function) {
        this.symbol = symbol;
        this.interval = interval;
        this.outputSize = outputSize;
        this.function = function;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getOutputSize() {
        return outputSize;
    }

    public void setOutputSize(String outputSize) {
        this.outputSize = outputSize;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "StockRequest{" +
                "symbol='" + symbol + '\'' +
                ", interval='" + interval + '\'' +
                ", outputSize='" + outputSize + '\'' +
                ", function='" + function + '\'' +
                '}';
    }
}
