package com.forecast.settings.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.forecast.settings.dao.ForecastRepository;
import com.forecast.settings.model.Forecast;
import com.forecast.settings.payload.*;
import com.forecast.settings.service.ForecastService;

@RestController
public class ForecastController {
	private static final Logger LOGGER=LoggerFactory.getLogger(ForecastController.class);
	@Autowired
	private ForecastRepository forecastRepo;
	
	@Autowired
	private ForecastService forecastService;
	
	
	@PostMapping("/saveForecast")
	public ResponseEntity<Forecast> createForecast(@RequestBody Forecast forecast) {
		Forecast newforecast=this.forecastService.saveForecast(forecast);
		return new ResponseEntity<Forecast>(newforecast,HttpStatus.CREATED);
	}
	

	@GetMapping("/forecasts")
	public List<Forecast> findForecastByFunctionName(
			@RequestParam("functionName") String functionName,
			@RequestParam("parameter") String parameter,
			@RequestParam("parameterValue") String parameterValue,Pageable pageable
			
			) {
		if((!StringUtils.isEmpty(functionName))&&(!StringUtils.isEmpty(parameter)&&(!StringUtils.isEmpty(parameterValue)))) {
			
			return forecastRepo.findByFunctionNameAndParameterAndParameterValue(functionName, parameter, parameterValue, pageable);
		}
			
		else if ((StringUtils.isEmpty(functionName))&&(!StringUtils.isEmpty(parameter)&&(!StringUtils.isEmpty(parameterValue)))) {
			return forecastRepo.findByParameterAndParameterValue(parameter, parameterValue, pageable);
		}
		
		else if(!StringUtils.isEmpty(functionName)&&(StringUtils.isEmpty(parameter)&&(StringUtils.isEmpty(parameterValue)))) {
			return forecastRepo.findByFunctionName(functionName, pageable);
			
		}else if((StringUtils.isEmpty(functionName))&&(!StringUtils.isEmpty(parameter)&&(StringUtils.isEmpty(parameterValue)))) {
			System.out.println("inside parameter method");
			return forecastRepo.findByParameter(parameter, pageable);
			
		}else if((StringUtils.isEmpty(functionName))&&(StringUtils.isEmpty(parameter)&&(!StringUtils.isEmpty(parameterValue)))) {
			return forecastRepo.findByParameterValue(parameterValue, pageable);
			
		}else if ((!StringUtils.isEmpty(functionName))&&(!StringUtils.isEmpty(parameter)&&(StringUtils.isEmpty(parameterValue)))) {
			return forecastRepo.findByFunctionNameAndParameter(functionName, parameter, pageable);
		}else if ((!StringUtils.isEmpty(functionName))&&(StringUtils.isEmpty(parameter)&&(!StringUtils.isEmpty(parameterValue)))) {
			return forecastRepo.findByFunctionNameAndParameterValue(functionName, parameterValue, pageable);
		}
			return forecastRepo.findAll();
			
		}
		
	
	@DeleteMapping("/forecast/{tenantId}")
	public ApiResponse  deleteForecast(@PathVariable Integer tenantId) {
		forecastRepo.deleteById(tenantId);
		return new ApiResponse("forecast is successfully deleted with id :" +tenantId, true);
		
	}
	
	
}
