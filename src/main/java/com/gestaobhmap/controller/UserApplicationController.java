package com.gestaobhmap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaobhmap.model.UserApplication;
import com.gestaobhmap.repository.UserApplicationRepository;

@RestController
public class UserApplicationController {

	@Autowired
	UserApplicationRepository userApplicationRepository;
	
	@GetMapping("/applications")
	public List<UserApplication> teste() {
		
		for(int i = 0;i <10;i++) {
			UserApplication user = new UserApplication("App"+ i);
			userApplicationRepository.save(user);
		}
		
		
		return userApplicationRepository.findAll();
	}
	
}
