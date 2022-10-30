package com.revature.banking.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.banking.model.Account;

@Repository("postgres-accounts")
public class AccountDataAccessService implements AccountDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	

	public AccountDataAccessService(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertAccount(UUID id, Account account) {
		// TODO Auto-generated method stub
		//System.out.println(id);
		final String sql = "INSERT INTO accounts (account_id, account_name, account_balance, customer_id) VALUES ('"+ id + "', '"
				+ account.getAccountName() + "', " + account.getAccountBalance() + ", '" + account.getCustomerId() + "');";
		jdbcTemplate.execute(sql);
		return 0;
	}

	@Override
	public List<Account> selectAllAccounts() {
		// TODO Auto-generated method stub
		final String sql = "SELECT account_id, account_name, account_balance, customer_id FROM accounts";
		return jdbcTemplate.query(sql, (resultSet, i) -> {
			UUID id = UUID.fromString(resultSet.getString("account_id"));
			String name = resultSet.getString("account_name");
			Double balance = resultSet.getDouble("account_balance");
			UUID customerId = UUID.fromString(resultSet.getString("customer_id"));
			return new Account(id, name, balance, customerId);
		});
	}

	@Override
	public Optional<Account> selectAccountById(UUID id) {
		// TODO Auto-generated method stub
		final String sql = "SELECT account_id, account_name, account_balance, customer_id FROM accounts WHERE account_id = ?";
		
		Account account = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
			UUID accountId = UUID.fromString(resultSet.getString("account_id"));
			String name = resultSet.getString("account_name");
			Double balance = resultSet.getDouble("account_balance");
			UUID customerId = UUID.fromString(resultSet.getString("customer_id"));
			return new Account(accountId, name, balance, customerId);
		}, new Object[] { id });

		return Optional.ofNullable(account);
	}

	@Override
	public int deleteAccountById(UUID id) {
		// TODO Auto-generated method stub
		final String sql = "DELETE FROM accounts WHERE account_id = '" + id + "'";

		jdbcTemplate.execute(sql);
		return 0;
	}

	@Override
	public int updateAccountById(UUID id, Account account) {
		// TODO Auto-generated method stub
		final String sql = "UPDATE accounts SET account_name = '" + account.getAccountName() + "',  account_balance = " + account.getAccountBalance() + 
				" WHERE account_id = '" + id +"'";
		jdbcTemplate.execute(sql);
		return 0;
	}

}
