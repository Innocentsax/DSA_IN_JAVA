package dev.Innocent.Section8.ConcurrencyAndMultithreading.Synchronization;

import dev.Innocent.Section8.StreamIntermidiate.Seat;

public class BankAccount {
    private double balance;
    private String name;

    private final Object lockName = new Object();
    private final Object lockBalance = new Object();

    public BankAccount(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        synchronized (lockName){
            this.name = name;
            System.out.println("Updated name = " + this.name);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        try{
            System.out.println("Deposit - Talking to the teller at the bank");
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (lockBalance){
            double origBalance = balance;
            balance += amount;
            System.out.printf("STARTING BALANCE: %.0f, DEPOSIT (%.0f)" +
                    " : NEW BALANCE = %.0f%n", origBalance, amount, balance);
            addPromoDollars(amount);
        }
    }

    private void addPromoDollars(double amount){
        if(amount >= 5000){
            synchronized (lockBalance){
                System.out.println("Congratulation, you earned a promotional deposit.");
                balance += 25;
            }
        }
    }

    public synchronized void withdraw(double amount){
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        double origBalance = balance;
        if(amount <= balance){
            balance -= amount;
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAW (%.0f)" +
                    " : NEW BALANCE = %.0f%n", origBalance, amount, balance);
        }else {
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f)" +
                    ": INSUFFICIENT FUNDS!", origBalance, amount);
        }

    }
}
