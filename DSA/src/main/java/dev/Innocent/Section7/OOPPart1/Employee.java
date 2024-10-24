package dev.Innocent.Section7.OOPPart1;

public class Employee extends Worker{
    private long employeeId;
    private String hireDate;

    public Employee(String name, String dateOfBirth, long employeeId, String hireDate) {
        super(name, dateOfBirth);
        this.employeeId = employeeId;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", hireDate='" + hireDate + '\'' +
                "} " + super.toString();
    }
}
