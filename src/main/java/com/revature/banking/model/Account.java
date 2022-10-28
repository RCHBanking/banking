package com.revature.banking.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {

	private int accountId;
	private String accountName;
	private Double accountBalance;
	private UUID customerId;

	public Account(@JsonProperty("id") int accountId,
				   @JsonProperty("name") String accountName,
				   @JsonProperty("balance")  Double accountBalance,
				   @JsonProperty("customer_id") UUID customerId) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
		this.customerId = customerId;
	}

	public int getAccountId() {
		return accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public UUID getCustomerId() {
		return customerId;
	}

}
