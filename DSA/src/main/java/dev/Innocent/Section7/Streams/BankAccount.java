package dev.Innocent.Section7.Streams;

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
}
