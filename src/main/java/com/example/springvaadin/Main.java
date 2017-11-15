//Muhammed ŞARA 150201123
package com.example.springvaadin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {


	private int temp;
	private int pressure;
	private int humidity;

	private String description;




	public int getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = (int) (Math.floor(temp) - 273);
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	@JsonProperty(value = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Main [temp=" + temp + ", pressure=" + pressure + ", humidity" + humidity + ", description " + description +"]";
	}
}