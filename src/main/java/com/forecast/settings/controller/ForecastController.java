package com.forecast.settings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.forecast.settings.dao.ForecastRepo;
import com.forecast.settings.model.Forecast;
import com.forecast.settings.payload.*;
import com.forecast.settings.service.ForecastService;

@RestController
public class ForecastController {
	
	@Autowired
	private ForecastRepo forecastRepo;
	
	@Autowired
	private ForecastService forecastService;
	
	
	@PostMapping("/saveForecast")
	public ResponseEntity<Forecast> createForecast(@RequestBody Forecast forecast) {
		Forecast newforecast=this.forecastService.saveForecast(forecast);
		return new ResponseEntity<Forecast>(newforecast,HttpStatus.CREATED);
	}
	
//	@GetMapping("/forecasts")
//	public List<Forecast> getAll(){
//		return forecastRepo.findAll();
//	}
	
	@GetMapping("/forecast/{tenantId}")
	public ResponseEntity<Forecast> getForecastById(@PathVariable Integer tenantId){
		Forecast forecast=this.forecastService.getForecastById(tenantId);
		return new ResponseEntity<Forecast>(forecast,HttpStatus.OK);
	}
	
//	@GetMapping("/forecasts")
//	public List<Forecast> findForecastByFunctionName(
//			@RequestParam("functionName") String functionName,
//			@RequestParam("parameter") String parameter,
//			@RequestParam("parameterValue") String parameterValue,Pageable pageable
//			
//			) {
//		if(functionName!=null) {
//			
//		if(parameter!=null) {
//		if(parameterValue!=null) {
//			return   forecastRepo.findByFunctionNameAndParameterAndParameterValue(functionName, parameter, parameterValue, pageable);
//				    
//				}
//					
//				
//					
//				
//			}
//		
//		}
//		else {
//			System.out.println("inside the else condition");
//			return  forecastRepo.findByParameterAndParameterValue(parameter, parameterValue, pageable);
//			
//		}
//		
//		return forecastRepo.findAll();
//	}
	
	@GetMapping("/forecasts")
	public List<Forecast> findForecastByFunctionName(
			@RequestParam("functionName") String functionName,
			@RequestParam("parameter") String parameter,
			@RequestParam("parameterValue") String parameterValue,Pageable pageable
			
			) {
		if(!StringUtils.isEmpty(functionName)) {
		 if(!StringUtils.isEmpty(parameter)) {
		if(!StringUtils.isEmpty(parameterValue)) {
			return   forecastRepo.findByFunctionNameAndParameterAndParameterValue(functionName, parameter, parameterValue, pageable);
		   
				}		
		 
			}
		
		}
		 else {
				System.out.println("inside  else method");
				return  forecastRepo.findByParameterAndParameterValue(parameter, parameterValue, pageable);
			}
		
		return forecastRepo.findAll();
	}

	
	
	@DeleteMapping("/forecast/{tenantId}")
	public ApiResponse  deleteForecast(@PathVariable Integer tenantId) {
		forecastRepo.deleteById(tenantId);
		return new ApiResponse("forecast is successfully deleted with id :" +tenantId, true);
		
	}
	
	
}
