package com.example.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.userservice.constant.*;
import com.example.userservice.Entity.User;
import com.example.userservice.exception.UserException;
import com.example.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public User createUser(User usr) {
		return repository.save(usr);
	}
    
	@Override
	public User updateUser(User usr) {
		return repository.save(usr);
	}

	
	@Override
	public List<User> getUsers() {
		return repository.findAll();
	}

	@Override
	public Optional<User> getUserById(int id) throws UserException {
		Optional<User> userInfo = repository.findById(id);
		if (userInfo.isEmpty()) {
			throw new UserException("User Id does not exist!",ErrorCode.USR_NOT_FOUND.getCode(),HttpStatus.OK);
		}
		return userInfo;
	}

	@Override
	public User deleteUser(User usr) {
		 repository.deleteById(usr.getId());
		 return usr;
		
	}

	
}
