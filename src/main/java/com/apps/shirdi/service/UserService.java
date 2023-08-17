package com.apps.shirdi.service;

import java.util.List;
import com.apps.shirdi.domain.entities.model.*;
import com.apps.shirdi.web.dto.*;

public interface UserService {

	List<UserDTO> getUsers();
	UserDTO getUserById(Long Id) throws Exception;
	List<UserDTO> createUsers(List<UserDTO> users);
	UserDTO getUserByEmail(String email) throws Exception;
}
