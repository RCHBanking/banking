package com.revature.banking.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.revature.banking.model.Transaction;

public interface TransactionDao {
	
	int insertTransaction(UUID id, Transaction transaction);

	default int insertTransaction(Transaction transaction) {
		UUID id = UUID.randomUUID();
		return insertTransaction(id, transaction);
	}

	List<Transaction> selectAllTransactions();

	Optional<Transaction> selectTransactionById(UUID id);

	int deleteTransactionById(UUID id);

	int updateTransactionById(UUID id, Transaction transaction);

}
