package com.revature.banking.model;

import java.util.UUID;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.internal.build.AllowPrintStacktrace;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@NoArgsConstructor
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	@Column(nullable = false)

	private Long id;
	@NotBlank(message = "name is required")
	private String name;
	@Email
	@NotEmpty(message = "email is required")
	private String email;
	@NotEmpty(message = "password is required")
	private String password;

	public Customer(@JsonProperty("id") Long id,
					@JsonProperty("name") String name,
					@JsonProperty("email") String email,
					@JsonProperty("password") String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
}
