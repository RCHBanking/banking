package com.revature.banking.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.banking.model.Customer;

@Repository("postgres")
public class CustomerDataAccessService implements CustomerDao {

	private final JdbcTemplate jdbcTemplate;

	public CustomerDataAccessService(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertCustomer(UUID id, Customer customer) {
		// TODO Auto-generated method stub
		final String sql = "INSERT INTO customers (customer_id, customers_name, customers_email, login, user_password) VALUES (uuid_generate_v4(), '"
				+ customer.getName() + "', '" + customer.getEmail() + "', '" + customer.getLogin() + "', '"
				+ customer.getPassword() + "')";
		jdbcTemplate.execute(sql);
		return 0;
	}

	@Override
	public List<Customer> selectAllCustomers() {
		// TODO Auto-generated method stub
		final String sql = "SELECT customer_id, customers_name, customers_email, login, user_password FROM customers";
		return jdbcTemplate.query(sql, (resultSet, i) -> {
			UUID id = UUID.fromString(resultSet.getString("customer_id"));
			String name = resultSet.getString("customers_name");
			String email = resultSet.getString("customers_email");
			String login = resultSet.getString("login");
			String password = resultSet.getString("user_password");
			return new Customer(id, name, email, login, password);
		});
	}

	@Override
	public Optional<Customer> selectCustomerById(UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int deleteCustomerById(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCustomerById(UUID id, Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

}
