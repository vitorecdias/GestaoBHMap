package com.gestaobhmap.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.DateType;

@Entity
@Table(name = "api_token")
public class APIToken {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String apiToken;
	
	private Calendar criadoEm;
    
	private DateType data;

	private Calendar expiraEm;
	
	//Getters and Setters
	public String getApiToken() {
		return apiToken;
	}

	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Calendar getExpiraEm() {
		return expiraEm;
	}

	public void setExpiraEm(Calendar expiraEm) {
		this.expiraEm = expiraEm;
	}

	public Calendar getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Calendar criadoEm) {
		this.criadoEm = criadoEm;
	}
	
	//Métodos em geral

	public String generateToken() {
		
		
		return "token";
	}
}
