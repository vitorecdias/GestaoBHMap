package com.gestaobhmap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaobhmap.model.User;
import com.gestaobhmap.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/usuarios")
	public List<User> teste() {
		
		for(int i = 0;i <10;i++) {
			User user = new User("fulano"+ i);
			userRepository.save(user);
		}
		
		
		return userRepository.findAll();
	}
	
}
