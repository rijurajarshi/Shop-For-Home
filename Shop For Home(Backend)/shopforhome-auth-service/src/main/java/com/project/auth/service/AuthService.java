package com.project.auth.service;

import com.project.auth.beans.Role;
import com.project.auth.entity.User;

public interface AuthService {

	Role authenticateUser(User user);

	Integer registerUser(User user);

	User getUser(String username);
}
