package com.gestaobhmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaobhmap.model.UserApplication;

@Repository
public interface UserApplicationRepository extends JpaRepository<UserApplication, Long> {

}