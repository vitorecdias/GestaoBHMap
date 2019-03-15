package com.gestaobhmap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaobhmap.model.User;
import com.gestaobhmap.repository.UserRepository;

@RestController
public class UserController {

	//@Autowired
  //  AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	/*
	 * @Autowired JwtTokenProvider tokenProvider;
	 */
	@GetMapping("/usuarios")
	public List<User> teste() {
		
		for(int i = 0;i <10;i++) {
			User user = new User();
			userRepository.save(user);
		}
		
		
		return userRepository.findAll();
	}
	
	/*
	 * @PostMapping("/login") public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
	 * 
	 * Authentication authentication = authenticationManager.authenticate( new
	 * UsernamePasswordAuthenticationToken( loginRequest.getUsernameOrEmail(),
	 * loginRequest.getPassword() ) );
	 * 
	 * SecurityContextHolder.getContext().setAuthentication(authentication);
	 * 
	 * String jwt = tokenProvider.generateToken(authentication); return
	 * ResponseEntity.ok(new JwtAuthenticationResponse(jwt)); }
	 */

}
