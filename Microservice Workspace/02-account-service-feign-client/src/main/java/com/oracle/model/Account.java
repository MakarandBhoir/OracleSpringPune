package com.oracle.model;

public class Account {
	private int accountId;
	private double balance;
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
