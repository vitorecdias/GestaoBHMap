package com.gestaobhmap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaobhmap.model.Token;
import com.gestaobhmap.repository.TokenRepository;


@RestController
public class UserTokenController {

	@Autowired
	TokenRepository tokenRepository;
	
	@GetMapping("/tokens")
	public List<Token> getTokens() {
		
		List <Token> tokensList = tokenRepository.findAll();
		
		return tokensList;
	}
	
}
