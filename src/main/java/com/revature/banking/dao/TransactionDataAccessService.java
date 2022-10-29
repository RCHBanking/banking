package com.revature.banking.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.banking.model.Account;
import com.revature.banking.model.Transaction;

@Repository("postgres-transactions")
public class TransactionDataAccessService implements TransactionDao {

	private final JdbcTemplate jdbcTemplate;

	public TransactionDataAccessService(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertTransaction(UUID id, Transaction transaction) {
		// TODO Auto-generated method stub
		final String sql = "INSERT INTO transactions (transaction_id, transaction_amount, other_details, account_id) VALUES ('"
				+ id + "', " + transaction.getAmount() + ", '" + transaction.getDetails() + "', '"
				+ transaction.getAccountId() + "')";
		jdbcTemplate.execute(sql);
		return 0;
	}

	@Override
	public List<Transaction> selectAllTransactions() {
		// TODO Auto-generated method stub
		final String sql = "SELECT transaction_id, transaction_amount, other_details, account_id FROM transactions";
		return jdbcTemplate.query(sql, (resultSet, i) -> {
			UUID account_id = UUID.fromString(resultSet.getString("transaction_id"));
			Double amount = resultSet.getDouble("transaction_amount");
			String details = resultSet.getString("other_details");
			UUID accountId = UUID.fromString(resultSet.getString("account_id"));
			return new Transaction(account_id, amount, details, accountId);
		});
	}

	@Override
	public Optional<Transaction> selectTransactionById(UUID id) {
		// TODO Auto-generated method stub
		final String sql = "SELECT transaction_id, transaction_amount, other_details, account_id FROM transactions WHERE transaction_id = ?";

		Transaction transaction = jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
			UUID transaction_id = UUID.fromString(resultSet.getString("transaction_id"));
			Double amount = resultSet.getDouble("transaction_amount");
			String details = resultSet.getString("other_details");
			UUID accountId = UUID.fromString(resultSet.getString("account_id"));
			return new Transaction(transaction_id, amount, details, accountId);
		}, new Object[] { id });

		return Optional.ofNullable(transaction);
	}

	@Override
	public int deleteTransactionById(UUID id) {
		// TODO Auto-generated method stub
		final String sql = "DELETE FROM transactions WHERE transaction_id = '" + id + "'";

		jdbcTemplate.execute(sql);
		return 0;
	}

	@Override
	public int updateTransactionById(UUID id, Transaction transaction) {
		// TODO Auto-generated method stub
		final String sql = "UPDATE transactions SET transaction_amount = " + transaction.getAmount()
				+ ",  other_details = '" + transaction.getDetails() + "' WHERE transaction_id = '" + id + "'";
		jdbcTemplate.execute(sql);
		return 0;
	}

}
