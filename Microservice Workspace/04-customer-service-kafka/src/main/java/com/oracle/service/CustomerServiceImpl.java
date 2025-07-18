package com.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.dao.CustomerDao;
import com.oracle.model.Customer;
import com.oracle.proxy.AccountServiceProxy;

import jakarta.transaction.Transactional;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private AccountServiceProxy accountServiceProxy;
	
	public CustomerServiceImpl() {
	}
	
	@Override
	public Customer getCustomerById(String customerId) {
		Customer customer = customerDao.findById(customerId).orElse(null);
		if (customer != null) {
			// call account microservice to get account details
			
			return customer;
		}
		throw new RuntimeException("Customer not found with ID: " + customerId);
	}

	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		if (customer != null) {
			customer = customerDao.save(customer);
			customer.getAccount().setCustomerId(customer.getCustomerId());
			accountServiceProxy.addAccount(customer.getAccount());
			return customer;
			// publish an event to notify by email
		} else {
			throw new RuntimeException("Customer cannot be null");
		}
	}

}
