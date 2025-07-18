package com.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.model.Account;
import com.oracle.service.AccountService;

@RestController
@RequestMapping("/account-api")
public class AccountContoller {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private Environment environment;
	
	// http://localhost:9091/account-api/account/customer/1001
	@GetMapping("/account/customer/{customerId}")
	public Account findAccountByCustomerId(@PathVariable("customerId") String customerId) {
		System.out.println("calling from instance = "+environment.getProperty("local.server.port"));
		return accountService.getAccountByCustomerId(customerId);
	}
	
	// http://localhost:9091/account-api/account
	@PostMapping("/account")
	public void addAccount(@RequestBody Account account) {
//		System.out.println("Account received: " + account);
		if (account != null) {
			accountService.registerNewAccount(account);
		} else {
			throw new RuntimeException("Account cannot be null");
		}
	}
}
