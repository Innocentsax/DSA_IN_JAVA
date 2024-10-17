package dev.Innocent.Section7.OOPPart1;

public class Main {
    public static void main(String[] args) {
        BankAccount bank = new BankAccount(2120100314, 4000,
                "Innocent Udo", "innocentcharlesudo@gmail.com", "+60-179549917");

        BankAccount newBank = new BankAccount(1234566, 6000, "Innocent", "08167876543",
                "oiuytgfrds0987654");


        bank.depositFunds(2000);
        bank.withdrawFunds(100.00);
        bank.withdrawFunds(200.00);


    }
}
