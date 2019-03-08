package com.gestaobhmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaobhmap.model.APIToken;

@Repository
public interface APITokenRepository extends JpaRepository<APIToken, Long> {

	
}