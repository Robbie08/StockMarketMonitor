package com.sevilladeux.StockMarketMonitor.common;

public class Constants {
    public static final String API_KEY = System.getenv("ALPHA_API_KEY");
    public static final String API_HOST = System.getenv("ALPHA_API_HOST");
    public static final long MINUTE = 60000;

    public static long generateExpirationTimeInMillis(){
        return System.currentTimeMillis() + (30 * MINUTE);
    }
}
