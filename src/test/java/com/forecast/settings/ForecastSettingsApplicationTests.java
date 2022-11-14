package com.forecast.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.forecast.settings.dao.ForecastRepository;
import com.forecast.settings.model.Forecast;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ForecastSettingsApplicationTests {

@Autowired
private ForecastRepository forecastRepo;


	
	@Test
	@Order(1)
	void createForecast() {
		
		Forecast f=new Forecast();
		f.setFunctionName("dc settings");
		f.setParameter("grouplevel");
		f.setParameterValue("testDC");
		f.setSetName("dcset2");
		
		f.setUpdatedBy("system");
		
		forecastRepo.save(f);
		assertNotNull(forecastRepo.findById(1).get() );
		
	}
	
	@Test
	@Order(2)
	public void testAllforecasts() {
		List<Forecast> forecast=forecastRepo.findAll();
		assertThat(forecast).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testSingleForecast() {
		Forecast forecast =forecastRepo.findById(1).get();
		assertEquals("dc settings",forecast.getFunctionName());
		
	}
	@Test
	@Order(4)
	public void testDeleteForecast() {
		forecastRepo.deleteById(1);
		assertThat(forecastRepo.existsById(1)).isFalse();
	}
	
}
