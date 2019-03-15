package com.gestaobhmap.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<UserApplication> listApplications() {
		
		/*for(int i = 1;i <=2;i++) {
			UserApplication user = new UserApplication("App"+ i);
			userApplicationRepository.save(user);
		}*/
		
		
		return userApplicationRepository.findAll();
	}
	
	@GetMapping("/applications/{id}")
	public Optional<UserApplication> findUserApplication(@PathVariable Long id) {
		Optional<UserApplication> userApplication = userApplicationRepository.findById(id);

		/*
		 * if (!userApplication.isPresent()) throw new StudentNotFoundException("id-" +
		 * id);
		 */
		return userApplication;
		
	}
	
	@PutMapping("/applications/{id}")
	public ResponseEntity<Object> updateUserApplication(@RequestBody UserApplication userApplication, @PathVariable long id) {

		
		Optional<UserApplication> studentOptional =  userApplicationRepository.findById(id);
		  
		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		userApplication.setId(id);
		
		userApplicationRepository.save(userApplication);

		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/applications")
	public ResponseEntity<Object> createUserApplication(@RequestBody UserApplication userApplication) {
		
		UserApplication savedUserApplication = userApplicationRepository.save(userApplication);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUserApplication.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@DeleteMapping("/applications/{id}")
	public void deleteUserApplication(@PathVariable Long id) {
		userApplicationRepository.deleteById(id);
	}
	
	
}
