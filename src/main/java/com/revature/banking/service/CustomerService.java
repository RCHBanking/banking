package com.revature.banking.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.banking.dao.CustomerDao;
import com.revature.banking.model.Customer;

@Service
public class CustomerService {

	private final CustomerDao customerDao;
	
	@Autowired
	public CustomerService(@Qualifier("postgres") CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}
	
	public int addCustomer(Customer customer) {

		return customerDao.insertCustomer(customer);
	}
	
	public List<Customer> getAllCustomers() {
		return customerDao.selectAllCustomers();
	}
	
	public Optional<Customer> getCustomerById(UUID id) {
		return customerDao.selectCustomerById(id);
	}
	
	public int deleteCustomer(UUID id) {
		return customerDao.deleteCustomerById(id);
	}
	
	public int updateCustomer(UUID id, Customer newCustomer) {
		return customerDao.updateCustomerById(id, newCustomer);
	}
}
