package com.domingueti.twitterbot.module.data.models;

import java.io.Serializable;
import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.domingueti.twitterbot.module.crypto.models.Crypto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_crypto_data")
public class CryptoData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter Long id;
	
	private @Getter @Setter Long cryptoId;
	
	private @Getter @Setter String name;
	
	private @Getter @Setter String symbol;
	
	private @Getter @Setter String priceUsd;
	
	private @Getter @Setter Boolean hasIncreased;
	
	private @Getter @Setter Double changeValue;
	
	//@OneToOne
	private @Getter Crypto crypto;
	
	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;
	
}//create CryptoDataDTO com hasIncreased @Null
