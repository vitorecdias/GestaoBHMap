package com.gestaobhmap.requests;

import java.security.Key;
import java.util.Date;

import com.gestaobhmap.model.APIToken;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class APITokenRequest {

	private String userName;
	private String timeStampCriacao;
	private String userApplicationName;
	private String apiName;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getTimeStampCriacao() {
		return timeStampCriacao;
	}
	
	public void setTimeStampCriacao(String timeStampCriacao) {
		this.timeStampCriacao = timeStampCriacao;
	}
	
	public String getUserApplicationName() {
		return userApplicationName;
	}
	
	public void setUserApplicationName(String userApplicationName) {
		this.userApplicationName = userApplicationName;
	}
	
	public String getApiName() {
		return apiName;
	}
	
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	
	
	//Métodos em geral

	@Override
	public String toString() {
		return "APITokenRequest [userName=" + userName + ", timeStampCriacao=" + timeStampCriacao
				+ ", userApplicationName=" + userApplicationName + ", apiName=" + apiName + "]";
	}

	public APIToken generateToken() {
		
		APIToken apiToken = new APIToken();
		
		//Gerar tokem aqui/algoritmo////
		Key key = MacProvider.generateKey();
				System.out.println(key);

		Date dateNow = new Date();
		Date expires = new Date(dateNow.getTime() + 86400000);

		String token = Jwts.builder().setSubject(this.userName).signWith(SignatureAlgorithm.HS256, key).setExpiration(expires).compact();
		
		String nome = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
		
		System.out.println("Nome do usuário recuperado da token: " +nome);
		
		apiToken.setApiToken(token);
		
		return apiToken;
	}

}
