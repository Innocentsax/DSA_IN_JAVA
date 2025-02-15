package dev.Innocent.Section7.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {
    private static int lastCustomerId = 10000000;
    private final String name;
    private final int customerId;
    private final List<BankAccount> accounts= new ArrayList<>();

    public BankCustomer(String name, double checkingAccount, double savingAccount) {
        this.name = name;
        this.customerId = lastCustomerId++;
        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, checkingAccount));
        accounts.add(new BankAccount(BankAccount.AccountType.SAVING, savingAccount));
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String[] accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings, i -> accounts.get(i).toString());
        return "Customer: %s (id:%015d)%n\t%s%n".formatted(name, customerId,
                String.join("\n\t", accountStrings));
    }
}
