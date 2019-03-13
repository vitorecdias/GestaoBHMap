package com.gestaobhmap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_application")
public class UserApplication {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long nome;
	
	
	public UserApplication(Long id, Long nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNome() {
		return nome;
	}
	public void setNome(Long nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "UserApplication [id=" + id + ", nome=" + nome + "]";
	}
	
	
}
