package com.oracle.service;

import com.oracle.model.Customer;

public interface CustomerService {
    void createCustomer(Customer c) throws Exception;
    Customer getCustomer(int id) throws Exception;
    void updateCustomer(Customer c) throws Exception;
    void deleteCustomer(int id) throws Exception;
}