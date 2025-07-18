package com.oracle.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.oracle.model.Account;
@Service
public class AccountServiceImpl implements AccountService{
	private List<Account> customerAccounts = new ArrayList<>();
	
	public AccountServiceImpl() {
		customerAccounts.add(new Account(1111, 5000.00, "1001"));
		customerAccounts.add(new Account(2222, 10000.00, "1002"));
	}
	
	@Override
	public Account getAccountByCustomerId(String customerId) {
		for (Account account : customerAccounts) {
			if (account.getCustomerId().equals(customerId)) {
				return account;
			}
		}
		throw new RuntimeException("Account not found for customer ID: " + customerId);
	}

}
