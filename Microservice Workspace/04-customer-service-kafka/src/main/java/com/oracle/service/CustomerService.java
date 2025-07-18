package com.oracle.service;

import com.oracle.model.Customer;

public interface CustomerService {
	public Customer getCustomerById(String customerId);
	public Customer addCustomer(Customer customer);
}
