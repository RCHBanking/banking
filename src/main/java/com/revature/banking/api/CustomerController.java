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

import com.revature.banking.model.Customer;
import com.revature.banking.service.CustomerService;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {
	
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping
	public void addCustomer(@Valid @NonNull @RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping(path = "{id}")
	public Customer getCustomerById(@PathVariable("id") UUID id) {
		return customerService.getCustomerById(id).orElse(null);
	}
	
	@DeleteMapping(path="{id}")
	public void deleteCustomerById(@PathVariable("id") UUID id) {
		customerService.deleteCustomer(id);
	}
	
	@PutMapping(path = "{id}")
	public void updateCustomer(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Customer customerToUpdate) {
		customerService.updateCustomer(id, customerToUpdate);
		
	}

}
