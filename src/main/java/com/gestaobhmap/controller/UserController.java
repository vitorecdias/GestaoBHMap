package com.gestaobhmap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaobhmap.model.User;
import com.gestaobhmap.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@GetMapping("/usuarios")
	public List<User> teste() {
		User user = new User();
		user.setId(1);
		user.setNome("vitor");
		userRepository.save(user);
		
		return userRepository.findAll();
	}
	
}
