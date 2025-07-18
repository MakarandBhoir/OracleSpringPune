package com.oracle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oracle.model.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, String> {
	// This interface will inherit methods like save(), findById(), deleteById()
	// from JpaRepository
	// You can also define custom query methods here if needed

}
