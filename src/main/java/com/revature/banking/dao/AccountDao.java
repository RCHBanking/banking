package com.revature.banking.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.revature.banking.model.Account;

public interface AccountDao {
	
	int insertAccount(UUID id, Account account);
	
	default int insertAccount(Account account) {
		UUID id = UUID.randomUUID();
		return insertAccount(id, account);
	}
	
	List<Account> selectAllAccounts();
	
	Optional<Account> selectAccountById(UUID id);
	
	int deleteAccountById(UUID id);
	
	int updateAccountById(UUID id, Account account);

}
