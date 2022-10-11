package com.forecast.settings.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.forecast.settings.model.Forecast;

public interface ForecastRepo extends JpaRepository<Forecast,Integer>{
	
	

	List<Forecast>findByFunctionName(String functionName,Pageable pageable);
	List<Forecast>findByParameterAndParameterValue(String parameter, String parameterValue,Pageable pageable);
	List<Forecast>findByFunctionNameAndParameterAndParameterValue(String functionName,String parameter,String parameterValue,Pageable pageable);
	List<Forecast>findByParameterValue(String parameterValue,Pageable pageable);
	List<Forecast>findByParameter(String parameter,Pageable pageable);
	List<Forecast>findByFunctionNameAndParameter(String functionName ,String parameter,Pageable pageable);
	List<Forecast>findByFunctionNameAndParameterValue(String functionName,String parameterValue,Pageable pageable);
	
}
