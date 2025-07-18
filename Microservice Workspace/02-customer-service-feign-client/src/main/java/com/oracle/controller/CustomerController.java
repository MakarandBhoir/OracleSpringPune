package com.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.model.Account;
import com.oracle.model.Customer;
import com.oracle.proxy.AccountServiceProxy;
import com.oracle.service.CustomerService;


@RestController
@RequestMapping("/customer-api")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountServiceProxy accountServiceProxy;
	
	// http://localhost:8081/customer-api/customer/1001
	@GetMapping("/customer/{customerId}")
	public Customer findCustomerById(@PathVariable("customerId") String customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		// Here you can call the Account Service micro-service to get account details
		// http://ACCOUNT-SERVICE/account-api/account/customer/1001
		Account account = accountServiceProxy.findAccountByCustomerId(customerId);
		customer.setAccount(account);
		
		return customer;
	}
}








