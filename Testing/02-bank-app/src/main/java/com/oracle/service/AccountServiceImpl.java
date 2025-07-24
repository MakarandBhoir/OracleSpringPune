package com.oracle.service;

import com.oracle.dao.AccountDAO;
import com.oracle.dao.AccountDAOImpl;
import com.oracle.model.Account;

public class AccountServiceImpl implements AccountService {
    protected AccountDAO dao = new AccountDAOImpl();

    public void createAccount(Account a) throws Exception {
        dao.create(a);
    }

    public Account getAccount(int id) throws Exception {
        return dao.read(id);
    }

    public void updateAccount(Account a) throws Exception {
        dao.update(a);
    }

    public void deleteAccount(int id) throws Exception {
        dao.delete(id);
    }
}