package com.example.userservice.constant;

import lombok.Getter;

@Getter
public enum ErrorCode {

	SUCCESS("USR_000","Success"),
	FAILURE("USR_111","Something went wrong, please try later"),
	USR_NOT_FOUND("USR_101","Usr not found");
	
	private String code;
	private String message;
	
	ErrorCode(String code,String message){
		this.code = code;
		this.message = message;
	}
}
