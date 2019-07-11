package com.naresh.bankingappspringdata.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.naresh.bankingappspringdata.exception.ErrorMessage;
import com.naresh.bankingappspringdata.exception.ServiceException;
import com.naresh.bankingappspringdata.exception.ValidatorException;

@ControllerAdvice
public class RESTExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<?> handleException(ServiceException e) {
		System.out.println("Exception"  + e.getMessage());
		ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@ExceptionHandler(ValidatorException.class)
	public ResponseEntity<?> handleException1(ValidatorException e) {
		System.out.println("Exception"  + e.getMessage());
		ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
	
