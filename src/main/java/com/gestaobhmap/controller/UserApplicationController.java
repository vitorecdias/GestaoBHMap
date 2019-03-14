package com.gestaobhmap.controller;

import java.util.List;
import java.util.Optional;

import org.jboss.jandex.TypeTarget.Usage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestaobhmap.model.UserApplication;
import com.gestaobhmap.repository.UserApplicationRepository;

@RestController
public class UserApplicationController {

	@Autowired
	UserApplicationRepository userApplicationRepository;
	
	@GetMapping("/applications")
	public List<UserApplication> teste() {
		
		for(int i = 1;i <=2;i++) {
			UserApplication user = new UserApplication("App"+ i);
			userApplicationRepository.save(user);
		}
		
		
		return userApplicationRepository.findAll();
	}
	
	@GetMapping("/applications/{id}")
	public Optional<UserApplication> buscaApplication(@PathVariable Long id) {
		
		
		return userApplicationRepository.findById(id);
	}
	
	@PutMapping("/applications/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody UserApplication userApplication, @PathVariable long id) {

		/*
		 * Optional<UserApplication> studentOptional =
		 * userApplicationRepository.findById(id);
		 * 
		 * if (!studentOptional.isPresent()) return ResponseEntity.notFound().build();
		 */
		userApplication.setId(id);
		
		userApplicationRepository.save(userApplication);

		return ResponseEntity.noContent().build();
	}
}
