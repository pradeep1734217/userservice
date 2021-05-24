package com.example.userservice.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	private String code;
	 
	private HttpStatus httpStatus;
	
	public UserException(String message, String code, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.code = code;
		this.httpStatus = httpStatus;
		
	}
}
