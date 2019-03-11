package com.gestaobhmap.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaobhmap.model.APIToken;

@Repository
public interface APITokenRepository extends JpaRepository<APIToken, Long> {

	public default boolean saveIfItNotExists(APIToken apiToken) {
		
		if(this.exists((Example<APIToken>) apiToken))
			return false;
		else {
			this.save(apiToken);
			return true;
		}
			
	}
}