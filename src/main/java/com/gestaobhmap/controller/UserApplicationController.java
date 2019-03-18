package com.gestaobhmap.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gestaobhmap.model.UserApplication;
import com.gestaobhmap.repository.UserApplicationRepository;

@RestController
public class UserApplicationController {

	@Autowired
	UserApplicationRepository userApplicationRepository;
	
	@GetMapping("/applications")
	public ResponseEntity<?> listApplications() {

		HttpHeaders header = new HttpHeaders();
		
		
		List<UserApplication> list = userApplicationRepository.findAll();
		
		header.add("X-Total-Count",list.size()+"");
		
		return ResponseEntity.ok().headers(header).body(list);
	}
	
	@GetMapping("/applications/{id}")
	public Optional<UserApplication> findUserApplication(@PathVariable Long id) {
		Optional<UserApplication> userApplication = userApplicationRepository.findById(id);

		return userApplication;
		
	}
	
	@PutMapping("/applications/{id}")
	public UserApplication updateUserApplication(@RequestBody UserApplication userApplication, @PathVariable long id) {

		userApplication.setId(id);
		
		UserApplication userApp = userApplicationRepository.save(userApplication);
		
		return userApp;
	}
	
	@PostMapping("/applications")
	public ResponseEntity<Object> createUserApplication(@RequestBody UserApplication userApplication) {
		
		UserApplication savedUserApplication = userApplicationRepository.save(userApplication);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUserApplication.getId()).toUri();

		return ResponseEntity.created(location).body(savedUserApplication);
	}
	
	@DeleteMapping("/applications/{id}")
	public Optional<UserApplication> deleteUserApplication(@PathVariable Long id) {
		Optional<UserApplication> userApplication = userApplicationRepository.findById(id);
		userApplicationRepository.deleteById(id);
		
		return userApplication;
	}
	
	
}
