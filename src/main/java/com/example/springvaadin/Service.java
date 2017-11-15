//Muhammed ŞARA 150201123
package com.example.springvaadin;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Service {
	
	RestTemplate restTemplate;
	Weather weather;
	
	public String sayHello(String name){
		return "Hello " + name;
	}
	
		public Weather getWeather(String city){
		
		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
    	restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    	
    	weather = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=1b7bdb012acdddc6a0fd97891c730f2f", Weather.class);
    	
    	return weather;
	}
	
	public Weather getWeather(){
		return this.weather;
	}
}
