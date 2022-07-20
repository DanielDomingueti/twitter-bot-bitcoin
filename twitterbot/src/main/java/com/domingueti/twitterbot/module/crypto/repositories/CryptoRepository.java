package com.domingueti.twitterbot.module.crypto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domingueti.twitterbot.module.crypto.models.Crypto;

public interface CryptoRepository extends JpaRepository<Crypto, Long>{

	Crypto findByIdAndDeletedAtIsNull(Long id);
	
}
