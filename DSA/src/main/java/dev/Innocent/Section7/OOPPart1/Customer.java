package dev.Innocent.Section7.OOPPart1;

public class Customer {
    private String name;
    private double credit_limit;
    private String emailAddress;

    public String getName() {
        return name;
    }

    public double getCredit_limit() {
        return credit_limit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Customer(String name, double credit_limit, String emailAddress) {
        this.name = name;
        this.credit_limit = credit_limit;
        this.emailAddress = emailAddress;
    }

    public Customer() {
        this("Innocent", 5000, "innocentchar@gmail.com");
    }

    public Customer(String name, String emailAddress) {
        this(name, 5000, emailAddress);
        this.name = name;
        this.emailAddress = emailAddress;
    }
}
