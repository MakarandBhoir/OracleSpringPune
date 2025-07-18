package com.oracle.service;

import com.oracle.model.Account;

public interface AccountService {
	public Account getAccountByCustomerId(String customerId);
}
