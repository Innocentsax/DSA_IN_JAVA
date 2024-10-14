package dev.Innocent.Section7.OOPPart1;

public class Main {
    public static void main(String[] args) {
        BankAccount bank = new BankAccount();
        // Use setter
        bank.setAccountBalance(4000);
        bank.setAccountNumber(2120100314);
        bank.setCustomerName("Innocent Udo");
        bank.setEmail("innocentcharlesudo@gmail.com");
        bank.setPhoneNumber("+60-179549917");

        bank.depositFunds(2000);
        bank.withdrawFunds(100.00);
        bank.withdrawFunds(200.00);


    }
}
