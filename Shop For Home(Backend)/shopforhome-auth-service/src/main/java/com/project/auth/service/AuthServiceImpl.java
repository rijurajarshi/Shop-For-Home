package com.project.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.auth.beans.Role;
import com.project.auth.entity.User;
import com.project.auth.exceptions.EmptyPasswordException;
import com.project.auth.exceptions.EmptyUsernameException;
import com.project.auth.exceptions.ExistingUserException;
import com.project.auth.repository.AuthRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthRepository authRepository;
	
	@Override
	public Role authenticateUser(User user) {
		User userEntity = authRepository.findByUsername(user.getUsername());
		if(userEntity.getPassword().equals(user.getPassword()))
			return new Role(userEntity.getRole());
		return null;
	}

	@Override
	public Integer registerUser(User user) {
		if(authRepository.findByUsername(user.getUsername()) != null)
			throw new ExistingUserException();
		if(user.getUsername().isEmpty())
			throw new EmptyUsernameException();
		if(user.getPassword().isEmpty())
			throw new EmptyPasswordException();
		if(user.getRole() == null)
			user.setRole("USER");
		return authRepository.save(user).getUserId();
	}

	@Override
	public User getUser(String username) {
		return authRepository.findByUsername(username);
	}

}
