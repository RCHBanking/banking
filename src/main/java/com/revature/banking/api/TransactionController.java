package com.revature.banking.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.banking.model.Transaction;
import com.revature.banking.service.TransactionService;

@RequestMapping("api/v1/transaction")
@RestController
public class TransactionController {
	
	private final TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		super();
		this.transactionService = transactionService;
	}
	
	@PostMapping
	public void addTransaction(@Valid @NonNull @RequestBody Transaction transaction) {
		transactionService.addTransaction(transaction);
	}
	
	@GetMapping
	public List<Transaction> getAllTransactions() {
		return transactionService.getAllTransactions();
	}
	
	@GetMapping(path = "{id}")
	public Transaction getTransactionById(@PathVariable("id") UUID id) {
		return transactionService.getTransactionById(id).orElse(null);
	}
	
	@DeleteMapping(path="{id}")
	public void deleteTransactionById(@PathVariable("id") UUID id) {
		transactionService.deleteTransaction(id);
	}
	
	@PutMapping(path = "{id}")
	public void updateTransaction(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Transaction transactionToUpdate) {
		transactionService.updateTransaction(id, transactionToUpdate);
		
	}

}
