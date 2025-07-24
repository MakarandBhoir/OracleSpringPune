package com.oracle.dao;

import com.oracle.model.Account;

public interface AccountDAO {
    void create(Account account) throws Exception;
    Account read(int id) throws Exception;
    void update(Account account) throws Exception;
    void delete(int id) throws Exception;
}