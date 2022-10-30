package com.revature.banking.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {

	private UUID id;
	private Double amount;
	private String details;
	private UUID accountId;
	
	public Transaction(@JsonProperty("id") UUID id, 
						@JsonProperty("amount") Double amount, 
						@JsonProperty("details") String details, 
						@JsonProperty("account_id") UUID accountId) {
		super();
		this.id = id;
		this.amount = amount;
		this.details = details;
		this.accountId = accountId;
	}

	public UUID getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public String getDetails() {
		return details;
	}

	public UUID getAccountId() {
		return accountId;
	}
	
	
}
