package com.forecast.settings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForecastSettingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForecastSettingsApplication.class, args);
		System.out.println("application is started on port : 9090");
	}

}
