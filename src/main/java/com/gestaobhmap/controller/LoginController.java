package com.gestaobhmap.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestaobhmap.repository.UserRepository;
import com.gestaobhmap.requests.LoginRequest;

	
@RestController
public class LoginController {
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/login")
	public HashMap<String, String> login(@RequestBody LoginRequest loginRequest) {
		
		HashMap<String, String> token = new HashMap<>();
		
		token.put("token", "123456");
		return token;
	}
	
}
