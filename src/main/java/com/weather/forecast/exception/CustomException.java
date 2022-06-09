package com.weather.forecast.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class CustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public CustomException(String errorMsg) {
		super(errorMsg);
		this.setMessage(errorMsg);
	}

}