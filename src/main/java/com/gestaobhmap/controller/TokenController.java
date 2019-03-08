package com.gestaobhmap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestaobhmap.model.APIToken;
import com.gestaobhmap.repository.APITokenRepository;
import com.gestaobhmap.requests.APITokenRequest;

@RestController
public class TokenController {

	@Autowired
	APITokenRepository apiTokenRepository;
	
	@PostMapping("/generateToken")
	public String generateToken(@Valid @RequestBody APITokenRequest requesteToken) {
		
		APIToken apiToken = new APIToken();
		
		String token = apiToken.generateToken();
		
		apiToken.setAccessAPIToken(token);
		
		apiTokenRepository.save(apiToken);
		
		System.out.println(requesteToken);
		System.out.println("TokenGerado!");
		
		return token;
	}
}
