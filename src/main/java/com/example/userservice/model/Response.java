package com.example.userservice.model;

import lombok.Data;

@Data
public class Response {

	private int status;
	private String message;
	
	public Response() {
		super();
	}
	
	public Response(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
}
