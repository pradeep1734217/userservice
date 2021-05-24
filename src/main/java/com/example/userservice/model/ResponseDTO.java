package com.example.userservice.model;

import lombok.Data;

@Data
public class ResponseDTO<T> {
	
	private Meta meta;
	
	T data;
	
}
