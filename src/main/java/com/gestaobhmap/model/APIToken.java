package com.gestaobhmap.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "api_token")
@IdClass(APITokenPK.class)
public class APIToken implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long userId;
	@Id
	private Long userApplicationId;
	@Id
	private Long apiId;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_api_token_token",nullable=false)
	private Token token;
	
	private Date criadoEm;

	private Date expiraEm;
	
	private Boolean desativada;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_seed_key",nullable=false)
	private SeedKey seedKey;
	
	public APIToken() {
		super();

		Date dateNow = new Date();
		this.criadoEm = new Date(dateNow.getTime());
		this.expiraEm = new Date(dateNow.getTime() + 864000000);
		this.desativada = false;
	}

	//Getters and Setters

	public Date getCriadoEm() {
		return criadoEm;
	}


	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}


	public Date getExpiraEm() {
		return expiraEm;
	}


	public void setExpiraEm(Date expiraEm) {
		this.expiraEm = expiraEm;
	}


	public Long getApiId() {
		return apiId;
	}


	public void setApiId(Long apiId) {
		this.apiId = apiId;
	}


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

	public SeedKey getSeedKey() {
		return seedKey;
	}

	public void setSeedKey(SeedKey seedKey) {
		this.seedKey = seedKey;
	}

	public Boolean getDesativada() {
		return desativada;
	}

	public void setDesativada(Boolean desativada) {
		this.desativada = desativada;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}
	
}
