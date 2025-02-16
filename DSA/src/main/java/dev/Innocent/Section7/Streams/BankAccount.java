package dev.Innocent.Section7.Streams;


import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {
    public enum AccountType {CHECKING, SAVING}
    private final AccountType accountType;
    private double balance;
    private final Map<Long, Transaction> transactions = new LinkedHashMap<>();

    public BankAccount(AccountType accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public Map<Long, Transaction> getTransactions() {
        return Map.copyOf(transactions);
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "%s Account -  Balance: $%.2f".formatted(accountType, balance);
    }

    public static void main(String[] args) {
//        BankAccount account = new BankAccount(BankAccount.AccountType.CHECKING, 500);
//        System.out.println(account);

        BankCustomer joe = new BankCustomer("Joe", 5000, 100000);
        System.out.println(joe);
    }

    void commitTransaction(int routingNumber, long transactionId,
                           String customerId, double amount){
        balance += amount;
        transactions.put(transactionId, new Transaction(routingNumber,
                transactionId, Integer.parseInt(customerId), amount));
    }
}
