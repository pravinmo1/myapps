package com.apps.shirdi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apps.shirdi.web.dto.UserDTO;
import com.apps.shirdi.service.UserService;

@RestController
public class UserController {
	
	@Autowired 
	UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<UserDTO> users = userService.getUsers();
		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<UserDTO> getUsers(@RequestParam("email") String email) throws Exception {
		UserDTO user = userService.getUserByEmail(email);
		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<List<UserDTO>> createUsers(@RequestBody List<UserDTO> userDTOs){
		userDTOs = userService.createUsers(userDTOs);
		return new ResponseEntity<List<UserDTO>>(userDTOs,HttpStatus.OK);
		
	}
	

}
