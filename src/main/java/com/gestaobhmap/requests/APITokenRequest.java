package com.gestaobhmap.requests;

import java.security.Key;

import com.gestaobhmap.model.APIToken;
import com.gestaobhmap.model.SeedKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class APITokenRequest {

	private Long userId;
	private Long userApplicationId;
	private Long apiId;
	

	public APITokenRequest() {
		super();
		this.userId = 0L;
		this.userApplicationId = 0L;
		this.apiId = 0L;
	}

	//Métodos em geral

	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getUserApplicationId() {
		return userApplicationId;
	}


	public void setUserApplicationId(Long userApplicationId) {
		this.userApplicationId = userApplicationId;
	}


	public Long getApiId() {
		return apiId;
	}


	public void setApiId(Long apiId) {
		this.apiId = apiId;
	}


	public APIToken generateToken() {
		
		APIToken apiToken = new APIToken();
		
		//Gerar tokem aqui/algoritmo////
		Key key = MacProvider.generateKey();
		SeedKey seedKey = new SeedKey(key);
		apiToken.setSeedKey(seedKey);

		String token = Jwts.builder().setSubject(this.userId+"").signWith(SignatureAlgorithm.HS256, key).setExpiration(apiToken.getExpiraEm()).compact();
		
		String nome = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().toString();
		
		System.out.println("Nome do usuário recuperado da token: " +nome);
		
		apiToken.setApiId(apiId);
		apiToken.setUserId(userId);
		apiToken.setApiToken(token);
		apiToken.setUserApplicationId(userApplicationId);
		
		return apiToken;
	}

	@Override
	public String toString() {
		return "APITokenRequest [userId=" + userId + ", userApplicationId=" + userApplicationId + ", apiId=" + apiId
				+ "]";
	}



}
