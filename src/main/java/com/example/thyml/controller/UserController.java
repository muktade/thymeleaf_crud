package com.example.thyml.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.thyml.dto.UserDto;
import com.example.thyml.entity.User;
import com.example.thyml.repository.UserRepository;
import com.example.thyml.service.UserService;
import com.example.thyml.utils.FileUtils;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/user/")
@AllArgsConstructor
public class UserController {
	
	private final UserService userService;
	private final FileUtils fileUtils;
	
	@GetMapping("list")
	public String getUsers(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("userList", users);
		return "index";
	}
	
	@GetMapping("user-form")
	public String addUserPage(Model model) {
		model.addAttribute("user", new User());
		return "user/add_user";
	}
	
	@PostMapping("save")
	public String addUser(@ModelAttribute @Valid User user, 
			BindingResult bindingResult) throws Exception{
		if (bindingResult.hasErrors()) {
			return "user/add_user";
		}

		userService.saveUser(user);
		return "redirect:list";
	}
	
	@GetMapping("delete/{userId}")
	public String deleteUser(@PathVariable("userId") Long id) {
		userService.deleteUser(id);
		return "redirect:/user/list";
	}

	@GetMapping("edit/{userId}")
	public String editUser(@PathVariable("userId") Long id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		return "user/add_user";
	}
	
}
