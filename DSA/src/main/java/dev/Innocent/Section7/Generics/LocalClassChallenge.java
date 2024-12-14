package dev.Innocent.Section7.Generics;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

record Employees(String first, String last, String hireDate){}

public class LocalClassChallenge {
    public static void main(String[] args) {
        Employees e1 = new Employees("Innocent", "Charles", "01/09/2024");
        Employees e2 = new Employees("Innocent", "Ufan", "05/09/2024");
        Employees e3 = new Employees("Innocent", "Eka", "04/09/2024");
        Employees e4 = new Employees("Innocent", "Uweme", "02/09/2024");

        List<Employees> list = new ArrayList<>(Arrays.asList(e1, e2, e3, e4));
        printOrderedList(list, "yearWorked");
    }

    public static void printOrderedList(List<Employees> eList, String sortField){
        int currentYear = LocalDate.now().getYear();

        class MyEmployee{
            Employees containedEmployee;
            int yearWorked;
            String fullName;

            public MyEmployee(Employees containedEmployee) {
                this.containedEmployee = containedEmployee;
                yearWorked = currentYear - Integer.parseInt(
                        containedEmployee.hireDate().split("/")[2]);
                fullName = String.join(" ", containedEmployee.first(), containedEmployee.last());
            }

            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(fullName, yearWorked);
            }
        }

        List<MyEmployee> list = new ArrayList<>();
        for(Employees employees : eList){
            list.add(new MyEmployee(employees));
        }

        var comparator = new Comparator<MyEmployee>(){

            @Override
            public int compare(MyEmployee o1, MyEmployee o2) {
                if(sortField.equals("name")){
                    return o1.fullName.compareTo(o2.fullName);
                }
                return o1.yearWorked - o2.yearWorked;
            }
        };

        list.sort(comparator);
        for (MyEmployee myEmployee : list){
            System.out.println(myEmployee);
        }
    }
}
