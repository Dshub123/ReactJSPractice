package com.MyTodoApp.security.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.MyTodoApp.security.UserPrinciple;

public interface JwtProvider {

	String generateToken(UserPrinciple auth);

	Authentication getAuthentication(HttpServletRequest request);

	boolean isTokenValid(HttpServletRequest request);

}
