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
	
	private String apiToken;
	
	private String criadoEm= "11/03/2019";

	private String expiraEm= "11/03/2020";
	
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

	public String getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(String criadoEm) {
		this.criadoEm = criadoEm;
	}

	public String getExpiraEm() {
		return expiraEm;
	}

	public void setExpiraEm(String expiraEm) {
		this.expiraEm = expiraEm;
	}

}
