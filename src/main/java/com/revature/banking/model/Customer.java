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
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", login=" + login + ", password="
				+ password + "]";
	}

	

}
