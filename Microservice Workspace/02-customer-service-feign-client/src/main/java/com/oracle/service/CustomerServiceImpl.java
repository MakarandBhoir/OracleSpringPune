package com.oracle.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	private List<Customer> customers = new ArrayList<>();
	public CustomerServiceImpl() {
		customers.add(new Customer("1001", "Bismah", "Shaikh", "bismah.shaikh@gmail.com"));
		customers.add(new Customer("1002", "Priyansh", "Mehrotra", "priyansh.mehrotra@gmail.com"));
	}
	
	@Override
	public Customer getCustomerById(String customerId) {
		for (Customer customer : customers) {	
			if (customer.getCustomerId().equals(customerId)) {
				// call Account Service to get account details
				return customer;
			}
		}
		throw new RuntimeException("Customer not found with ID: " + customerId);
	}

}
