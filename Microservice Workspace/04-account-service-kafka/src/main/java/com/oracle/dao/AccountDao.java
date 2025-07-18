package com.oracle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oracle.model.Account;
@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {

	// Method to find an account by customer ID
	Account findByCustomerId(String customerId);

	// Method to update the balance of an account
	@Modifying
	@Query("UPDATE Account a SET a.balance = :balance WHERE a.accountId = :accountId")
	void updateBalance(@Param("accountId") int accountId, @Param("balance") double balance);

}
