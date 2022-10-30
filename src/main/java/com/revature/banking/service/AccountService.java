package com.revature.banking.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.banking.dao.AccountDao;
import com.revature.banking.model.Account;

@Service
public class AccountService {
	
	private final AccountDao accountDao;
	
	@Autowired
	public AccountService(@Qualifier("postgres-accounts") AccountDao accountDao) {
		super();
		this.accountDao = accountDao;
	}
	
	public int addAccount(Account account) {
		return accountDao.insertAccount(account);
	}
	
	public List<Account> getAllAccounts() {
		return accountDao.selectAllAccounts();
	}
	
	public Optional<Account> getAccountById(UUID id) {
		return accountDao.selectAccountById(id);
	}
	
	public int deleteAccount(UUID id) {
		return accountDao.deleteAccountById(id);
	}
	
	public int updateAccount(UUID id, Account newAccount) {
		return accountDao.updateAccountById(id, newAccount);
	}

}
