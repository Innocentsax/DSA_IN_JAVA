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


        interface EnhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }

        EnhancedComparator<Persons> comparatorMixed = new EnhancedComparator<>() {

            @Override
            public int compare(Persons o1, Persons o2) {
                int result = o1.lastName().compareTo(o2.lastName());
                return (result == 0 ? secondLevel(o1, o2) : result);
            }

            @Override
            public int secondLevel(Persons o1, Persons o2) {
                return o1.firstName().compareTo(o2.firstName());
            }
        };
        people.sort(comparatorMixed);
        System.out.println(people);

    }
}
