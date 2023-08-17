package com.apps.shirdi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.apps.shirdi.web.exception.DataNotFoundException;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleCustomException(DataNotFoundException ex){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("errorCode", ex.getErrorCode().getCode());
		map.put("errorMessage", ex.getMessage());
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
		
	}

}
