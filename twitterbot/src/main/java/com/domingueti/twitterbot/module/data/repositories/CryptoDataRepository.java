package com.domingueti.twitterbot.module.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.twitterbot.module.data.models.CryptoData;

public interface CryptoDataRepository extends JpaRepository<CryptoData, Long> {

	CryptoData findByIdAndDeletedAtIsNull(Long id);
	
}
