package com.gestaobhmap.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestaobhmap.model.APIToken;
import com.gestaobhmap.repository.APITokenRepository;
import com.gestaobhmap.requests.APITokenRequest;

@CrossOrigin(maxAge = 3600)
@RestController
public class APITokenController {

	@Autowired
	APITokenRepository apiTokenRepository;
	
	@PostMapping("/generateToken")
	public APIToken generateToken(@Valid @RequestBody APITokenRequest requestToken) {
		
		APIToken apiToken = requestToken.generateToken();
		
		apiTokenRepository.save(apiToken);
		
		System.out.println("Requisição: "+requestToken);
		System.out.println("TokenGerado!");
		
		return apiToken;
	}
	
	 @CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/tokens")
	public List<APIToken> getTokens() {
		
		List <APIToken> tokensList = apiTokenRepository.findAll();
		
		return tokensList;
	}
	
}
