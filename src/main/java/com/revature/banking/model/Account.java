package com.revature.banking.model;

import java.util.UUID;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.Data;
import lombok.ToString;

@Data
public class Account {

	
	private UUID accountId;
	private String accountName;
	private Double accountBalance;
	private UUID customerId;

	public Account(@JsonProperty("id") UUID accountId,
				   @JsonProperty("account_name") String accountName,
				   @JsonProperty("account_balance")  Double accountBalance,
				   @JsonProperty("customer_id") UUID customerId) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
		this.customerId = customerId;
	}

	public UUID getAccountId() {
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

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", accountBalance=" + accountBalance
				+ ", customerId=" + customerId + "]";
	}
	
	

}
