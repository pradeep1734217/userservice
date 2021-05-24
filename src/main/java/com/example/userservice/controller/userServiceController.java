package com.example.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.Entity.User;
import com.example.userservice.constant.Constant;
import com.example.userservice.constant.ErrorCode;
import com.example.userservice.model.Meta;
import com.example.userservice.model.ResponseDTO;
import com.example.userservice.service.UserService;

@RestController
public class userServiceController {

	@Autowired
	UserService userservice;

	@GetMapping("/usr/{id}")
	public ResponseEntity<ResponseDTO<Optional<User>>> getUserDetail(@PathVariable int id) {

		ResponseDTO<Optional<User>> usr = new ResponseDTO<Optional<User>>();
		usr.setMeta(new Meta(ErrorCode.SUCCESS.getCode(), Constant.STATUS_SUCCESS, ErrorCode.SUCCESS.getMessage()));
		usr.setData(userservice.getUserById(id));
		return new ResponseEntity<ResponseDTO<Optional<User>>>(usr, HttpStatus.OK);

	}

	@PostMapping("/usr")
	public ResponseEntity<ResponseDTO<User>> saveUserDetail(@RequestBody User usr) {

		ResponseDTO<User> responseDto = new ResponseDTO<User>();
		responseDto.setMeta(
				new Meta(ErrorCode.SUCCESS.getCode(), Constant.STATUS_SUCCESS, ErrorCode.SUCCESS.getMessage()));
		responseDto.setData(userservice.createUser(usr));
		return new ResponseEntity<ResponseDTO<User>>(responseDto, HttpStatus.CREATED);

	}

	@PutMapping("/usr")
	public ResponseEntity<ResponseDTO<User>> updateUserDetail(@RequestBody User usr) {
		Optional<User> userById = userservice.getUserById(usr.getId());
		User user = userById.get();
		User createUser = userservice.createUser(user);
		ResponseDTO<User> responseDto = new ResponseDTO<User>();
		responseDto.setMeta(
				new Meta(ErrorCode.SUCCESS.getCode(), Constant.STATUS_SUCCESS, ErrorCode.SUCCESS.getMessage()));
		responseDto.setData(createUser);
		return new ResponseEntity<ResponseDTO<User>>(responseDto, HttpStatus.CREATED);

	}

	@DeleteMapping("/usr")
	public ResponseEntity<ResponseDTO<User>> deleteUserDetail(@RequestBody User usr) {
		ResponseDTO<User> responseDto = new ResponseDTO<User>();
		responseDto.setMeta(
				new Meta(ErrorCode.SUCCESS.getCode(), Constant.STATUS_SUCCESS, ErrorCode.SUCCESS.getMessage()));
		responseDto.setData(userservice.deleteUser(usr));
		return new ResponseEntity<ResponseDTO<User>>(responseDto, HttpStatus.OK);

	}

	@GetMapping("/usr/findAllUsers")
	public ResponseEntity<ResponseDTO<List<User>>> getUsers(){
		ResponseDTO<List<User>> responseDto = new ResponseDTO<List<User>>();
		responseDto.setMeta(
				new Meta(ErrorCode.SUCCESS.getCode(), Constant.STATUS_SUCCESS, ErrorCode.SUCCESS.getMessage()));
		responseDto.setData(userservice.getUsers());
		return new ResponseEntity<ResponseDTO<List<User>>>(responseDto, HttpStatus.OK);
	}
}
