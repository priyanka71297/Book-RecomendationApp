package com.recommendation.RecomendationApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class UserAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;  
	
	public UserAlreadyExistsException() {
		 super();
 }
	public UserAlreadyExistsException(String exceptionMessage) {
	 super(exceptionMessage);
 }

}

