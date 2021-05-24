package com.example.userservice.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "User")
public class User {
	@Id
	private Integer id;
	private String fname;
	private String surname;
	private String dob;
	private String title;
		
	
}
