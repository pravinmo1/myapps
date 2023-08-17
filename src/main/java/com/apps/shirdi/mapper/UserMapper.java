package com.apps.shirdi.mapper;

import org.springframework.stereotype.Component;

import com.apps.shirdi.domain.entities.model.User;
import com.apps.shirdi.web.dto.*;

@Component
public class UserMapper {
	
	public UserDTO mapToUserDto(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setUserId(user.getUserId());
		return userDto;
	}
	
	public User mapToUser(UserDTO userDTO) {
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		//user.setUserId(userDTO.getUserId());
		return user;
	}

}
