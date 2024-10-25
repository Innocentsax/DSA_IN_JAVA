package dev.Innocent.Section7.OOPPart1;

public class SalariedEmployee extends Employee{
    private double annualSalary;
    private boolean isRetired;


    public SalariedEmployee(String name, String dateOfBirth, long employeeId,
                            String hireDate, double annualSalary) {
        super(name, dateOfBirth, employeeId, hireDate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double collectPay(){
        double payCheck = annualSalary / 26;
        return (isRetired) ? 0.9 * payCheck : payCheck;
    }

    public void retire(){
        terminate("12/10/2026");
    }
}
