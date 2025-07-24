package com.oracle.service;

import com.oracle.dao.CustomerDAO;
import com.oracle.dao.CustomerDAOImpl;
import com.oracle.model.Customer;

public class CustomerServiceImpl implements CustomerService {
    protected CustomerDAO dao = new CustomerDAOImpl();

    public void createCustomer(Customer c) throws Exception {
        dao.create(c);
    }

    public Customer getCustomer(int id) throws Exception {
        return dao.read(id);
    }

    public void updateCustomer(Customer c) throws Exception {
        dao.update(c);
    }

    public void deleteCustomer(int id) throws Exception {
        dao.delete(id);
    }
}