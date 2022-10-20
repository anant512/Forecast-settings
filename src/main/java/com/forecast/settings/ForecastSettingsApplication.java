package com.forecast.settings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForecastSettingsApplication {
	private static final Logger  LOGGER=LoggerFactory.getLogger(ForecastSettingsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ForecastSettingsApplication.class, args);
		LOGGER.warn("we are testing the forecast Settings  application");
		LOGGER.info("server started on port : 9090");
		
	}

}
