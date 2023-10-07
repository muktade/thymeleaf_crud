package com.example.thyml.service;

import java.util.List;

import com.example.thyml.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thyml.dto.UserDto;
import com.example.thyml.entity.User;
import com.example.thyml.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final FileUtils fileUtils;

	@Override
	public User saveUser(User user) {
		String userPhotoPath = fileUtils.getUserPhotoFilePath(user);
		try {
			fileUtils.saveFile(user.getPhoto(), userPhotoPath);
			user.setPhotoPath(userPhotoPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		User user = new User();
		user.setId(id);
		userRepository.delete(user);
	}

	@Override
	public User getUser(Long id) {
		return userRepository.getUserById(id).orElse(new User());
	}

}
