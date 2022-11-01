package com.revature.banking.model;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;

@Data
public class Customer {
	
	private UUID id;
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
}
