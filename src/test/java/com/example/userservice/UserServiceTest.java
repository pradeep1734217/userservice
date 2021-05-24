package com.example.userservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.userservice.Entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;

public class UserServiceTest extends UserserviceApplicationTests {
	

	@Autowired
	private UserService  service;
	
	@MockBean
	private UserRepository repository;

	
	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream.of(new User(2,"Pawan","kumar","12-06-1993","This is Pawan"),
				new User(4,"Rajwsh","kumar","12-06-1993","This is Pawan")).collect(Collectors.toList()));
		assertEquals(2, service.getUsers().size());
		
	}
	@Test
	public void saveUserTest() {
		User user = new User(2,"Pawan","kumar","12-06-1993","This is Pawan");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.createUser(user));
	}
	@Test
	public void deleteUserTest() {
		User user = new User(2,"Pawan","kumar","12-06-1993","This is Pawan");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.deleteUser(user));
	}

}
