package com.gestaobhmap.model;

import java.security.Key;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seed_key")
public class SeedKey {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Key seedKey;
	
	public SeedKey() {
		super();
		this.seedKey = null;
	}
	public SeedKey(Key seedKey) {
		super();
		this.seedKey = seedKey;
	}

	public Key getSeedKey() {
		return seedKey;
	}

	public void setSeedKey(Key seedKey) {
		this.seedKey = seedKey;
	}
	
}
