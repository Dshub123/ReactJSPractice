package com.MyTodoApp.services;

import java.util.Optional;

import com.MyTodoApp.entities.User;

public interface UserService
{

	Optional<User> findByUsername(String username);

	User createUser(User user);
	
	User signInAndReturnJWT(User signInRequest);

}
