package com.apps.shirdi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.shirdi.domain.entities.model.User;
import com.apps.shirdi.web.dto.UserDTO;
import com.apps.shirdi.web.exception.DataNotFoundException;
import com.apps.shirdi.web.exception.error.ErrorCode;
import com.apps.shirdi.mapper.UserMapper;
import com.apps.shirdi.domain.entities.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	private UserMapper userMapper;

	@Override
	public List<UserDTO> getUsers() {
		List<User> users = (List<User>)userRepository.findAll();
		List<UserDTO> userDto = users.stream().map(user -> userMapper.mapToUserDto(user)).collect(Collectors.toList());
		return userDto.size()>0 ? userDto : null;
	}

	@Override
	public UserDTO getUserById(Long id) throws Exception {
		return userRepository.findById(id).map(user->userMapper.mapToUserDto(user))
				.orElseThrow(()-> new DataNotFoundException("User not found", ErrorCode.USER_NOT_FOUND));
	}
	

	@Override
	public List<UserDTO> createUsers(List<UserDTO> userDTOs) {
		List<User> users = userDTOs.stream().map(userDTO -> userMapper.mapToUser(userDTO)).collect(Collectors.toList());
		users = (List<User>) userRepository.saveAll(users);
		List<UserDTO> userDto = users.stream().map(user -> userMapper.mapToUserDto(user)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public UserDTO getUserByEmail(String email) throws Exception {
		Optional<UserDTO> userDtoOpt = Optional.ofNullable(userRepository.getByEmail(email)).map(user -> userMapper.mapToUserDto(user));
		return userDtoOpt.orElseThrow(()-> new DataNotFoundException("User not found", ErrorCode.USER_NOT_FOUND));
	}

}
