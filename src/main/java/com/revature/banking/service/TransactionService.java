package com.revature.banking.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.banking.dao.TransactionDao;
import com.revature.banking.model.Transaction;

@Service
public class TransactionService {
	
private final TransactionDao transactionDao;
	
	@Autowired
	public TransactionService(@Qualifier("postgres-transactions") TransactionDao transactionDao) {
		super();
		this.transactionDao = transactionDao;
	}
	
	public int addTransaction(Transaction transaction) {
		return transactionDao.insertTransaction(transaction);
	}
	
	public List<Transaction> getAllTransactions() {
		return transactionDao.selectAllTransactions();
	}
	
	public Optional<Transaction> getTransactionById(UUID id) {
		return transactionDao.selectTransactionById(id);
	}
	
	public int deleteTransaction(UUID id) {
		return transactionDao.deleteTransactionById(id);
	}
	
	public int updateTransaction(UUID id, Transaction newTransaction) {
		return transactionDao.updateTransactionById(id, newTransaction);
	}
}


