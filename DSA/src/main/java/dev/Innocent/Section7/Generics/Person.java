package dev.Innocent.Section7.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Person {

    record Persons(String firstName, String lastName){
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {
        List<Persons> people = new ArrayList<>(Arrays.asList(
                new Person.Persons("Innocent", "Udo"),
                new Persons("David", "Koz"),
                new Persons("Normal", "guy"),
                new Persons("Ufan", "Uwem"),
                new Persons("Ubeh", "Joy")
        ));

        // Using anonymous class
        people.sort((o1, o2) -> o1.lastName.compareTo(o2.firstName));
        System.out.println(people);
    }

    interface EnhancedComparator<T> extends Comparator<T>{
        int secondLevel(T o1, T o2);
    }


}
