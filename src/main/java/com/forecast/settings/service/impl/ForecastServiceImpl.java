package com.forecast.settings.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import com.forecast.settings.dao.ForecastRepository;
import com.forecast.settings.exceptions.ResourceNotFoundException;
import com.forecast.settings.model.Forecast;
import com.forecast.settings.service.ForecastService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class ForecastServiceImpl implements ForecastService {
	@Autowired
	ForecastRepository forecastRepo;
	
	

	@Override
	public Forecast saveForecast(@RequestBody Forecast forecast) {
	    Forecast newforecast=this.forecastRepo.save(forecast);
	    return newforecast;
	}

	@Override
	public Forecast getForecastById(Integer tenantId) {
        Forecast forecast=this.forecastRepo.findById(tenantId).orElseThrow(()->new ResourceNotFoundException("Forecast","tenantId",tenantId));
		return forecast;
	}

	@Override
	public void deleteForecast(Integer tenantId) {
		Forecast forecast=this.forecastRepo.findById(tenantId).orElseThrow(()-> new ResourceNotFoundException("Forecast", "tenantId",tenantId));
		this.forecastRepo.delete(forecast);
		
	}




	@Override
	public List<Forecast> getForecastByFunctionNameAndParamerterAndParameterValue(String functionName, String parameter,
			String parameterValue, Pageable pageable) {
		List<Forecast> forecasts=this.forecastRepo.findByFunctionNameAndParameterAndParameterValue(functionName, parameter, parameterValue, pageable);
		return forecasts;
	}

	@Override
	public List<Forecast> getForecastByFunctionName(String functionName, Pageable pageable) {
		List<Forecast> forecasts=this.forecastRepo.findByFunctionName(functionName, pageable);
		return forecasts;
	}

	@Override
	public List<Forecast> getForecastByParameterAndParameterValue(String parameter, String parameterValue,
			Pageable pageable) {
		List<Forecast> forecasts=this.forecastRepo.findByParameterAndParameterValue(parameter, parameterValue, pageable);
		return forecasts;
	}

	@Override
	public List<Forecast> findByParameterValue(String parameterValue, Pageable pageable) {
		List<Forecast> forecasts=this.forecastRepo.findByParameterValue(parameterValue, pageable);
		return forecasts;
	}

	@Override
	public List<Forecast> findByParameter(String parameter, Pageable pageable) {
	List<Forecast> forecasts=this.forecastRepo.findByParameter(parameter, pageable);
		return forecasts;
	}

	@Override
	public List<Forecast> findByFunctionNameAndParameter(String functionName, String parameter, Pageable pageable) {
		List<Forecast> forecasts=this.forecastRepo.findByFunctionNameAndParameter(functionName, parameter, pageable);
		return forecasts;
	}

	@Override
	public List<Forecast> findByFunctionNameAndParameterValue(String functionName, String parameterValue,
			Pageable pageable) {
		List<Forecast> forecasts= this.forecastRepo.findByFunctionNameAndParameterValue(functionName, parameterValue, pageable);
		return forecasts;
	}

	

	

}
