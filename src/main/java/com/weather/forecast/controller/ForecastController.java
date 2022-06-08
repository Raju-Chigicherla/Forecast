package com.weather.forecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.weather.forecast.service.ForecastService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

// @formatter:off

/**
 * The Class ForecastController.
 */
@RestController
public class ForecastController {

	/** The forecast service. */
	@Autowired
	private ForecastService forecastService;

	/**
	 * Home page.
	 *
	 * @return the model and view
	 */
	@GetMapping("/")
	public ModelAndView homePage() {
		return new ModelAndView("index");
	}

	/**
	 * Weather forecast average.
	 *
	 * @param city the city
	 * @return the response entity
	 */
	@Operation(summary = "This is to fetch next 3 days Weather forecast")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Details of Next 3 days Weather Forecast", content = { @Content(mediaType = "application/json") }),
	})
	@GetMapping(value = "/forecast", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView weatherForecastAverage(@RequestParam(required = true, name = "city") String city) {
		ResponseEntity<?> forecastAvg = forecastService.weatherForecastAverage(city);
		Object response = forecastAvg.getBody();
		
		ModelAndView mv = new ModelAndView("weather-data");
		mv.addObject("weatherDetails", response);
		return mv;
//		return rforecastService.weatherForecastAverage(city);
	}

	/**
	 * Gets the forecast data.
	 *
	 * @param city the city
	 * @return the forecast data
	 */
	@GetMapping(value = "/getForecast", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getForecastData(@RequestParam(required = true, name = "city") String city) {
		return forecastService.getForecastInfo(city);
	}
}

// @formatter:on