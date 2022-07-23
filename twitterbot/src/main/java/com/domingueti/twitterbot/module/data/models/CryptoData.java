package com.domingueti.twitterbot.module.data.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	
	private @Getter @Setter String name;
	
	private @Getter @Setter String symbol;
	
	private @Getter @Setter BigDecimal priceUsd;
	
	private @Getter @Setter Boolean hasIncreased;
	
	private @Getter @Setter String status;
	
	private @Getter @Setter BigDecimal changePercentage;
	
	@CreationTimestamp
	private @Getter Timestamp createdAt;

	@UpdateTimestamp
	private @Getter Timestamp updatedAt;

	private @Getter @Setter Timestamp deletedAt;
	
}//create CryptoDataDTO com hasIncreased @Null
