package com.example.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.userservice.constant.Constant;
import com.example.userservice.constant.ErrorCode;
import com.example.userservice.model.Meta;
import com.example.userservice.model.ResponseDTO;

@ControllerAdvice
public class RestExceptionHandler { 
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ResponseDTO<?>> exceptionToDoHandler(UserException ex){
		Meta meta = new Meta(ex.getCode(),Constant.STATUS_FAILURE, ex.getMessage());
		ResponseDTO<?> resp = new ResponseDTO<>();
		resp.setMeta(meta);
		return new ResponseEntity<ResponseDTO<?>>(resp, ex.getHttpStatus());
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO<?>> exceptionHandler(Exception ex){
		Meta meta = new Meta(ErrorCode.FAILURE.getCode(), Constant.STATUS_FAILURE, ErrorCode.FAILURE.getMessage());
		ResponseDTO<?> resp = new ResponseDTO<>();
		resp.setMeta(meta);
		return new ResponseEntity<ResponseDTO<?>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
