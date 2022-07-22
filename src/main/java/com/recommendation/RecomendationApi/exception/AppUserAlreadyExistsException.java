package com.recommendation.RecomendationApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class AppUserAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;  
	
	public AppUserAlreadyExistsException() {
		 super();
 }
	public AppUserAlreadyExistsException(String exceptionMessage) {
	 super(exceptionMessage);
 }

}
