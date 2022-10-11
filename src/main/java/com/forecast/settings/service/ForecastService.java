package com.forecast.settings.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.forecast.settings.model.Forecast;

public interface ForecastService {
	
	
	// create settings 
	
	Forecast saveForecast(Forecast forecast);
	
	// get settings by functionName, parameter and parameterValue
	
	List<Forecast> getForecastByFunctionNameAndParamerterAndParameterValue(String functionName,String parameter,String parameterValue,Pageable pageable);
	
	// get settings by tenantId
	
	Forecast getForecastById(Integer tenantId);
	
	// get settings by functionName
	List<Forecast> getForecastByFunctionName(String functionName,Pageable pageable);
	
	// get forecast by parameter and paraneterValue
	List<Forecast> getForecastByParameterAndParameterValue(String parameter,String parameterValue,Pageable pageable);
	
	// get settings by parameterValue
	List<Forecast>findByParameterValue(String parameterValue,Pageable pageable);
	
	// get settings by parameter 
	List<Forecast>findByParameter(String parameter,Pageable pageable);
	
	// get settings by functionName and parameter
	List<Forecast>findByFunctionNameAndParameter(String functionName ,String parameter,Pageable pageable);
	
	// get settings by functionName and prameterValue
	List<Forecast>findByFunctionNameAndParameterValue(String functionName,String parameterValue,Pageable pageable);
	
	// delete settings by id
	
	void deleteForecast(Integer tenantId);

	
	
	
	
	
	
	
	
	
	
}
