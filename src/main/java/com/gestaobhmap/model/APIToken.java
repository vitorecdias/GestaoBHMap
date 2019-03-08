package com.gestaobhmap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "api_token")
public class APIToken {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String accessAPIToken;
    
	public String getAccessAPIToken() {
		return accessAPIToken;
	}

	public void setAccessAPIToken(String accessAPIToken) {
		this.accessAPIToken = accessAPIToken;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String generateToken() {
		
		
		return "token";
	}
}
