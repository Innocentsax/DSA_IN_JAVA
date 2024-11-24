package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private Customer findCustomer(String customerName){
        for(var customer : customers){
            if(customer.getName().equalsIgnoreCase(customerName)){
                return customer;
            }
        }
        System.out.printf("Customer (%s) wasn't found %n", customerName);
        return null;
    }

    public boolean newCustomer(String customerName, double initialTransaction){
        if(findCustomer(customerName) == null){
            Customer customer = new Customer(customerName, initialTransaction);
            customers.add(customer);
            System.out.println("New Customer added: " + customer);
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double transactions){
        Customer customer = findCustomer(customerName);
        if(customer != null){
            customer.addTransaction(transactions);
            return true;
        }
        return false;
    }
}