package com.oracle.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.oracle.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void createCustomer(Customer customer) {
		entityManager.persist(customer);
	}
	
	@Override
	public Customer readCustomerById(Long id) {
		return entityManager.find(Customer.class, id);
	}
	
	@Override
	public List<Customer> readAllCustomers() {
		return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
	}
	@Override
	public void updateCustomer(Customer customer) {
		
	}

	@Override
	public void deleteCustomer(Long id) {
		
	}   
}
