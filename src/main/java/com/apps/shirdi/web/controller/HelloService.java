package com.apps.shirdi.web.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {

	@GetMapping("/hello/{name}")
	public String helloDocker(@PathVariable(value = "name") String name) {
		String response = "Hello " + name + " Response received on : " + new Date();
		System.out.println(response);
		return response;

	}
	
	@GetMapping("/ping")
	public <T> ResponseEntity<String> hello() {
		return new ResponseEntity<String>("OK", HttpStatus.OK);
	}


}
