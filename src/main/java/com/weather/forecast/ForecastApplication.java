package com.weather.forecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

// @formatter:off

/**
 * The Class ForecastApplication.
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Forecast API", version = "1.0", description = "Weather Forecast Information"))
public class ForecastApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SpringApplication.run(ForecastApplication.class, args);
	}

}

// @formatter:on