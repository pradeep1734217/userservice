package com.example.userservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
	
	private int errorcode;
	private String message;
}
