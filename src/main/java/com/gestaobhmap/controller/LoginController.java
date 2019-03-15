package com.gestaobhmap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaobhmap.repository.UserRepository;
	
@RestController
public class LoginController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/teste")
	public void teste() {
		
		System.out.println("teste66666666666666666666666666666");
		
	}
	
}
