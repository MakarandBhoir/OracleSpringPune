package com.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.dao.CustomerDao;
import com.oracle.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDao.createCustomer(customer);
	}

	@Override
	public Customer findCustomerById(Long id) {
		return customerDao.readCustomerById(id);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerDao.readAllCustomers();
	}

	@Override
	public void modifyCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public void removeCustomer(Long id) {
		customerDao.deleteCustomer(id);
	}

}
