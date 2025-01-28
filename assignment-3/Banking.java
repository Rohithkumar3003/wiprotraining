package com.oop;

import java.util.*;

abstract class Account {
    private int accountNumber;
    private double balance;

    public Account(int accountNumber, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public abstract void calculateInterest();

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Balance: " + String.format("%.2f", balance);
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest added: " + interest);
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(int accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && getBalance() + overdraftLimit >= amount) {
            double newBalance = getBalance() - amount;
            if (newBalance < 0) {
                overdraftLimit += newBalance; // Adjust overdraft
            }
            super.deposit(-amount); // Simulate withdrawal
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }

    @Override
    public void calculateInterest() {
        System.out.println("Current accounts do not earn interest.");
    }
}

class Customer {
    private int id;
    private String name;
    private List<Account> accounts;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccount(int accountNumber) {
        return accounts.stream().filter(a -> a.getAccountNumber() == accountNumber).findFirst().orElse(null);
    }

    public void displayAccounts() {
        accounts.forEach(System.out::println);
    }
}

class Transactions {
    public static void transferFunds(Account fromAccount, Account toAccount, double amount) {
        if (amount > 0 && fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transferred " + amount + " from Account " + fromAccount.getAccountNumber() + " to Account " + toAccount.getAccountNumber());
        } else {
            System.out.println("Transfer failed. Insufficient funds or invalid amount.");
        }
    }
}

public class Banking {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Arjun");
        Customer customer2 = new Customer(2, "Balu");

        Account savings1 = new SavingsAccount(101, 5000, 3.5);
        Account current1 = new CurrentAccount(102, 2000, 1000);

        Account savings2 = new SavingsAccount(201, 3000, 4.0);

        customer1.addAccount(savings1);
        customer1.addAccount(current1);
        customer2.addAccount(savings2);

        System.out.println("--- Initial Account Details ---");
        customer1.displayAccounts();
        customer2.displayAccounts();

        System.out.println("\n--- Transactions ---");
        savings1.deposit(1000);
        current1.withdraw(2500);
        Transactions.transferFunds(customer1.getAccount(101), customer2.getAccount(201), 2000);

        System.out.println("\n--- Final Account Details ---");
        customer1.displayAccounts();
        customer2.displayAccounts();

        System.out.println("\n--- Interest Calculation ---");
        savings1.calculateInterest();
        savings2.calculateInterest();
    }
}
