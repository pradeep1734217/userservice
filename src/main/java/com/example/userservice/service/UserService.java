package com.example.userservice.service;

import java.util.List;
import java.util.Optional;

import com.example.userservice.Entity.User;

public interface UserService {
	//create user
	public User createUser(User usr);
	//read user
	public Optional<User> getUserById(int id);
	//update User
	public User updateUser(User usr);
	//delete User
	public User deleteUser(User usr);
	//getall users
	public List<User> getUsers();
	
	
	

}
