package com.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.model.Account;
import com.oracle.service.AccountService;

@RestController
@RequestMapping("/account-api")
public class AccountContoller {
	@Autowired
	private AccountService accountService;
	
	// http://localhost:9091/account-api/account/customer/1001
	@GetMapping("/account/customer/{customerId}")
	public Account findAccountByCustomerId(@PathVariable("customerId") String customerId) {
		return accountService.getAccountByCustomerId(customerId);
	}
}
