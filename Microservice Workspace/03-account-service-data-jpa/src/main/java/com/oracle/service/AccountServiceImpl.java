package com.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.dao.AccountDao;
import com.oracle.model.Account;
@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public Account getAccountByCustomerId(String customerId) {
		Account account = accountDao.findByCustomerId(customerId);
		if (account != null) {
			return account;
		}
		throw new RuntimeException("Account not found for customer ID: " + customerId);
	}

	@Override
	public void registerNewAccount(Account account) {
		accountDao.save(account);
	}

}
