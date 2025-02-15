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
}
