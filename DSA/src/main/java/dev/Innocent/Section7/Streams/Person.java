package dev.Innocent.Section7.Streams;

import java.util.Arrays;

public class Person {
    private String name;
    private String dob;
    private Person[] kids;

    public Person(String name, String dob, Person[] kids) {
        this.name = name;
        this.dob = dob;
        this.kids = kids;
    }

    public Person(String name, String dob) {
        this(name, dob, null);
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public Person[] getKids() {
        return kids;
    }

    public void setKids(Person[] kids) {
        this.kids = kids;
    }

    @Override
    public String toString() {
        String kidString = "n/a";
        if(kids != null){
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name);
            kidString = String.join(", ", names);
        }
        return name + ", dob = " + dob + ", kids = " + kidString;
    }

    public static void main(String[] args) {
        Person jane = new Person();
        jane.setName("Jane");
        Person jim = new Person();
        jim.setName("Jim");
        Person joe = new Person();
        joe.setName("Joe");
        Person john = new Person();
        john.setName("John");
        john.setDob("05/05/1900");
        john.setKids(new Person[]{jane, jim, joe});
        System.out.println(john);
    }
}
