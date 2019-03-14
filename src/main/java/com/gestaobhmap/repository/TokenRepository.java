package com.gestaobhmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaobhmap.model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

}