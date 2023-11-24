package com.amazon.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
	
	// method : any exception occurs at any flie , class anthign
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> exceptionHandler(MethodArgumentNotValidException e) {
		Map<String, String> errorMap = new HashMap<>();
		BindingResult result = e.getBindingResult();
		for (FieldError error : result.getFieldErrors()) {
			errorMap.put(error.getField(), error.getDefaultMessage());
		}
		return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
	}

}
