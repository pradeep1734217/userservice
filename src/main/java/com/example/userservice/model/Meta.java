package com.example.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Meta {

	private String code;
	private short status;
	private String message;
	
}
