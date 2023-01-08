package com.sevilladeux.StockMarketMonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockMarketMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMarketMonitorApplication.class, args);
	}

}
