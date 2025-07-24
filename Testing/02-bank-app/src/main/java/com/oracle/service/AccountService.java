package com.oracle.service;

import com.oracle.model.Account;

public interface AccountService {
    void createAccount(Account a) throws Exception;
    Account getAccount(int id) throws Exception;
    void updateAccount(Account a) throws Exception;
    void deleteAccount(int id) throws Exception;
}