package com.oracle.ui;

import java.util.Scanner;

import com.oracle.model.Account;
import com.oracle.model.Customer;
import com.oracle.service.AccountService;
import com.oracle.service.AccountServiceImpl;
import com.oracle.service.CustomerService;
import com.oracle.service.CustomerServiceImpl;

public class MainUI {

    private static final Scanner sc = new Scanner(System.in);
    private static final CustomerService customerService = new CustomerServiceImpl();
    private static final AccountService accountService = new AccountServiceImpl();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== Customer & Account Management ===");
            System.out.println("1. Create Customer");
            System.out.println("2. View Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1 -> createCustomer();
                    case 2 -> viewCustomer();
                    case 3 -> updateCustomer();
                    case 4 -> deleteCustomer();
                    case 5 -> {
                        System.out.println("Exiting... Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void createCustomer() throws Exception {
        System.out.println("\n-- Create New Account --");
        Account acc = new Account();
        System.out.print("Enter Account ID: ");
        acc.setId(Integer.parseInt(sc.nextLine()));
        System.out.print("Enter Account Number: ");
        acc.setAccountNumber(sc.nextLine());
        System.out.print("Enter Balance: ");
        acc.setBalance(Double.parseDouble(sc.nextLine()));
        accountService.createAccount(acc);

        System.out.println("\n-- Create Customer --");
        Customer customer = new Customer();
        System.out.print("Enter Customer ID: ");
        customer.setId(Integer.parseInt(sc.nextLine()));
        System.out.print("Enter Name: ");
        customer.setName(sc.nextLine());
        System.out.print("Enter Email: ");
        customer.setEmail(sc.nextLine());
        customer.setAccount(acc);

        customerService.createCustomer(customer);
        System.out.println("Customer created successfully.");
    }

    private static void viewCustomer() throws Exception {
        System.out.print("\nEnter Customer ID to view: ");
        int id = Integer.parseInt(sc.nextLine());
        Customer customer = customerService.getCustomer(id);
        if (customer != null) {
            System.out.println("\n-- Customer Details --");
            System.out.println("ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            Account acc = customer.getAccount();
            System.out.println("Account ID: " + acc.getId());
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Balance: " + acc.getBalance());
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void updateCustomer() throws Exception {
        System.out.print("\nEnter Customer ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        Customer customer = customerService.getCustomer(id);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Enter new name (leave blank to keep: " + customer.getName() + "): ");
        String name = sc.nextLine();
        if (!name.isBlank()) customer.setName(name);

        System.out.println("Enter new email (leave blank to keep: " + customer.getEmail() + "): ");
        String email = sc.nextLine();
        if (!email.isBlank()) customer.setEmail(email);

        Account acc = customer.getAccount();
        System.out.println("Enter new account number (leave blank to keep: " + acc.getAccountNumber() + "): ");
        String accNum = sc.nextLine();
        if (!accNum.isBlank()) acc.setAccountNumber(accNum);

        System.out.println("Enter new balance (enter -1 to keep: " + acc.getBalance() + "): ");
        double balance = Double.parseDouble(sc.nextLine());
        if (balance >= 0) acc.setBalance(balance);

        accountService.updateAccount(acc);
        customerService.updateCustomer(customer);
        System.out.println("Customer updated successfully.");
    }

    private static void deleteCustomer() throws Exception {
        System.out.print("\nEnter Customer ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        Customer customer = customerService.getCustomer(id);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        customerService.deleteCustomer(id);
        accountService.deleteAccount(customer.getAccount().getId());
        System.out.println("Customer and associated account deleted.");
    }
}
