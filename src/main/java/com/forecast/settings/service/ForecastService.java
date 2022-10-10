package com.forecast.settings.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.forecast.settings.model.Forecast;

public interface ForecastService {
	
	
	// create settings 
	
	Forecast saveForecast(Forecast forecast);
	
	// get settings by parameter and parameterValue
	
	List<Forecast> getForecastByFunctionNameAndParamerterAndParameterValue(String functionName,String parameter,String parameterValue,Pageable pageable);
	
	// get settings by tenantId
	
	Forecast getForecastById(Integer tenantId);
	
	// get settings by functionName
	List<Forecast> getForecastByFunctionName(String functionName,Pageable pageable);
	
	// get forecast by parameter and paraneterValue
	List<Forecast> getForecastByParameterAndParameterValue(String parameter,String parameterValue,Pageable pageable);
	
	// delete settings by id
	
	void deleteForecast(Integer tenantId);

	
	
	
	
	
	
	
	
	
	
}
