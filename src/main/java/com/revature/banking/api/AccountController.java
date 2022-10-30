package com.revature.banking.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.banking.model.Account;
import com.revature.banking.service.AccountService;

@RequestMapping("api/v1/account")
@RestController
public class AccountController {
	
	private final AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@PostMapping
	public void addAccount(@Valid @NonNull @RequestBody Account account) {
		accountService.addAccount(account);
	}
	
	@GetMapping
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}
	
	@GetMapping(path = "{id}")
	public Account getAccountById(@PathVariable("id") UUID id) {
		return accountService.getAccountById(id).orElse(null);
	}
	
	@DeleteMapping(path="{id}")
	public void deleteAccountById(@PathVariable("id") UUID id) {
		accountService.deleteAccount(id);
	}
	
	@PutMapping(path = "{id}")
	public void updateAccount(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Account accountToUpdate) {
		accountService.updateAccount(id, accountToUpdate);
		
	}
}
