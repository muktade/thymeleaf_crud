package com.example.thyml.service;

import java.util.List;

import com.example.thyml.dto.UserDto;
import com.example.thyml.entity.User;

public interface UserService {
	
	User saveUser(User user);
	
	List<User> getUsers();
	
	void deleteUser(Long id);
	
	User getUser(Long id);
}
