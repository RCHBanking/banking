package com.revature.banking.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
	
	private UUID id;
	@NotBlank
	private String name;
	private String email;
	private String login;
	private String password;
	
	public Customer(@JsonProperty("id") UUID id,
					@JsonProperty("name") String name,
					@JsonProperty("email") String email, 
					@JsonProperty("login") String login, 
					@JsonProperty("password") String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public UUID getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getLogin() {
		return this.login;
	}

	public String getPassword() {
		return this.password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", login=" + login + ", password="
				+ password + "]";
	}

	

}
