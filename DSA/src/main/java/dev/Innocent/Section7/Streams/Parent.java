package dev.Innocent.Section7.Streams;

public class Parent {
    private String name;
    private String dob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "name = '" + name + '\'' + ", dob = '" + dob + '\'';
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
    }
}
