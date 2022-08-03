package com.project.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.auth.entity.User;
import com.project.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findByRole("USER");
	}

	@Override
	public List<User> getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findByUserId(id);
	}
	

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}

	@Override
	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user).getUserId();
	}

}
