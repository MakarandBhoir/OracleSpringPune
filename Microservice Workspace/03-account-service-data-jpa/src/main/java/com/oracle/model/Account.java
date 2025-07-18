package com.oracle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "myaccount")
public class Account {
	@Id
	@Column(name = "account_id")
	private int accountId;
	
	@Column(name = "balance")
	private double balance;
	
	@Column(name = "customer_id")
	private String customerId;
	public Account() {
		
	}
	public Account(int accountId, double balance, String customerId) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.customerId = customerId;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}
