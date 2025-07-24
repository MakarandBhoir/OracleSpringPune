package com.oracle.dao;

import com.oracle.model.Customer;

public interface CustomerDAO {
    void create(Customer customer) throws Exception;
    Customer read(int id) throws Exception;
    void update(Customer customer) throws Exception;
    void delete(int id) throws Exception;
}