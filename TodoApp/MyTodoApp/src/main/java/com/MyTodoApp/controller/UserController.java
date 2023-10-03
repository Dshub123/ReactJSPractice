package com.MyTodoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyTodoApp.entities.User;
import com.MyTodoApp.services.UserService;
@RestController
@RequestMapping("/api/authentication")
public class UserController 
{
	@Autowired
	private UserService userService;

	
	@PostMapping("/sign-up")
	public ResponseEntity<?> signUp(@RequestBody User user)
	{
	
		if(userService.findByUsername(user.getUsername()).isPresent())
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
	}
	
	
	@PostMapping("/sign-in")
	public ResponseEntity<?> signIn(@RequestBody User user)
	{
		System.out.println(user);
		return new ResponseEntity<>(userService.signInAndReturnJWT(user),HttpStatus.OK);
	}
	
	
	

}
