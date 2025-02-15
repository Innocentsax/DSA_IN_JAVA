package dev.Innocent.Section7.Streams;

import java.util.Arrays;

public class BankAccount {
    public enum AccountType {CHECKING, SAVING}
    private final AccountType accountType;
    private final double balance;

    public BankAccount(AccountType accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(BankAccount.AccountType.CHECKING, 500);
        System.out.println(account);
    }
}
