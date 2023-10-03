package com.MyTodoApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.MyTodoApp.entities.Role;
import com.MyTodoApp.entities.User;
import com.MyTodoApp.repository.UserRepository;
import com.MyTodoApp.security.UserPrinciple;
import com.MyTodoApp.security.jwt.JwtProvider;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtProvider jwtProvider;
	

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	//Find Username
	@Override
	public Optional<User> findByUsername(String username)
	{
		
		return userRepository.findByUsername(username);
	}
	
	
	
	//save user Details
	@Override
	public User createUser(User user)
	{
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}


	@Override
	public User signInAndReturnJWT(User signInRequest) 
	{
		System.out.println(signInRequest);
             Authentication authentication=authenticationManager.authenticate(
				 
				 new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
				 );
		 
		
		 UserPrinciple userPrinciple=(UserPrinciple) authentication.getPrincipal();
		 
		 String jwt=jwtProvider.generateToken(userPrinciple);
		 System.out.println(jwt);
		 User signInUser = userPrinciple.getUser();
		 
		 signInUser.setToken(jwt);
		
		 return signInUser;
		 
	}

}
