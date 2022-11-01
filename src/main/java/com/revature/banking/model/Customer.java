package com.revature.banking.model;

import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity(name="Customer")
@Table(
		name = "customer",
		uniqueConstraints = {
				@UniqueConstraint(name = "customer_email_unique", columnNames = "email")
		}
		)

public class Customer {
	@Id
	@SequenceGenerator()
	
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
}
