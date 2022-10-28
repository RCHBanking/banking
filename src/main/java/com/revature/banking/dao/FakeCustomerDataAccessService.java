package com.revature.banking.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.revature.banking.model.Customer;

@Repository("fakeDao")
public class FakeCustomerDataAccessService implements CustomerDao{
	
	private static List<Customer> DB = new ArrayList<>();
	
	public int insertCustomer(UUID id, Customer customer) {
		DB.add(new Customer(id, customer.getName(), customer.getEmail(), customer.getLogin(), customer.getPassword()));
		return 1;
	}

	@Override
	public List<Customer> selectAllCustomers() {
		// TODO Auto-generated method stub
		return DB;
	}

	@Override
	public Optional<Customer> selectCustomerById(UUID id) {
		// TODO Auto-generated method stub
		return DB.stream().filter(customer -> customer.getId().equals(id)).findFirst();
	}

	@Override
	public int deleteCustomerById(UUID id) {
		// TODO Auto-generated method stub
		Optional<Customer> customerMaybe = selectCustomerById(id);
		if (customerMaybe.isEmpty()) {
			return 0;
		}
		DB.remove(customerMaybe.get());
		return 1;
	}

	@Override
	public int updateCustomerById(UUID id, Customer update) {
		// TODO Auto-generated method stub
		return selectCustomerById(id)
				.map(customer -> {
			int indexOfCustomerToUpdate = DB.indexOf(customer);
			if (indexOfCustomerToUpdate >= 0) {
				DB.set(indexOfCustomerToUpdate, new Customer(id, update.getName(), update.getEmail(), update.getLogin(), update.getPassword()));
				return 1;
			}
			return 0;
		})
		.orElse(0);
	}

}
