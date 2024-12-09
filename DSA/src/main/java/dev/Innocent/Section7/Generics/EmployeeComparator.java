package dev.Innocent.Section7.Generics;

import java.util.Comparator;

public class EmployeeComparator <T extends Employee> implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
