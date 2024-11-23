package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transaction){

    public Customer(String name, double initialDeposit){
        this(name.toUpperCase(), new ArrayList<Double>(500));
        transaction.add(initialDeposit);
    }
}

public class AutoBoxingChallenge {
    public static void main(String[] args) {
        Customer bob = new Customer("Bob S", 10000);
        System.out.println(bob);

        Bank bank = new Bank("UOB Bank");
        bank.addNewCustomer("Innocent Udo", 1500000);
        System.out.println(bank);

        bank.addTransaction("Innocent Udo", -5000);
        bank.addTransaction("Innocent Udo", -2000);
        bank.printStatement("Innocent Udo");
    }
}

class Bank{
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }

    private Customer getCustomer(String customerName) {
        for(var customer : customers){
            if(customer.name().equalsIgnoreCase(customerName)){
                return customer;
            }
        }
        System.out.printf("Customer (%s) wasn't found %n", customerName);
        return null;
    }

    public void addNewCustomer(String customerName, double initialDeposit){
        if(getCustomer(customerName) == null){
            Customer customer = new Customer(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("New Customer added: " + customer);
        }
    }

    public void addTransaction(String name, double transactionAmount){
        Customer customer = getCustomer(name);
        if(customer != null){
            customer.transaction().add(transactionAmount);
        }
    }

    public void printStatement(String customerName){
        Customer customer = getCustomer(customerName);
        if(customer == null){
            return;
        }
        System.out.println("-".repeat(30));
        System.out.println("Customer Name: " + customerName);
        System.out.println("Transaction");
        for(double d : customer.transaction()){
            System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "debit" : "credit");
        }
    }
}
