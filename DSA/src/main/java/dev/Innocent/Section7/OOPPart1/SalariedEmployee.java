package dev.Innocent.Section7.OOPPart1;

public class SalariedEmployee extends Employee{
    private double annualSalary;
    private boolean isRetired;


    public SalariedEmployee(String name, String dateOfBirth, String endDate) {
        super(name, dateOfBirth, endDate);
    }
}
