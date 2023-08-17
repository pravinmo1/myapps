package com.apps.shirdi.domain.entities.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apps.shirdi.domain.entities.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User getByEmail(String email);

}
