package com.tns_Assignment4;

class Bank {
    private static int totalAccounts = 0;

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void incrementAccounts() {
        totalAccounts++;
    }
}

abstract class Account {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;

    public Account(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
        Bank.incrementAccounts();
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract double getBalance();

    public void displayInfo() {
        System.out.println("Account No: " + accountNumber +
                           ", Holder: " + accountHolderName +
                           ", Balance: ₹" + balance);
    }
}

class SavingsAccount extends Account {
    private final double interestRate = 0.03;

    public SavingsAccount(String accNo, String name) {
        super(accNo, name);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount + (amount * interestRate);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("⚠️ Insufficient funds in Savings Account.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

class CheckingAccount extends Account {
    private final double overdraftLimit = 500.0;

    public CheckingAccount(String accNo, String name) {
        super(accNo, name);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
        } else {
            System.out.println("⚠️ Withdrawal exceeds overdraft limit.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

class Transaction {
    public final double transactionFee = 10.0;

    public final void performTransaction(Account acc, String type, double amount) {
        System.out.println("\n🔄 Processing " + type + " of ₹" + amount);

        if (type.equalsIgnoreCase("deposit")) {
            acc.deposit(amount - transactionFee);
        } else if (type.equalsIgnoreCase("withdraw")) {
            acc.withdraw(amount + transactionFee);
        } else {
            System.out.println("❌ Invalid transaction type.");
            return;
        }

        System.out.println("✅ Transaction complete. Current Balance: ₹" + acc.getBalance());
    }
}

public class BankApp {
    public static void main(String[] args) {
        Account savings = new SavingsAccount("SA1001", "Alice");
        Account checking = new CheckingAccount("CA2001", "Bob");

        Transaction txn = new Transaction();

        savings.displayInfo();
        checking.displayInfo();

        txn.performTransaction(savings, "deposit", 1000);
        txn.performTransaction(checking, "withdraw", 300);

        savings.displayInfo();
        checking.displayInfo();

        System.out.println("\n📊 Total Bank Accounts: " + Bank.getTotalAccounts());
    }
}
