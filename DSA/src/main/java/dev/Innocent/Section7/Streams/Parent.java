package dev.Innocent.Section7.Streams;

public class Parent {
    private String name;
    private String dob;
    protected int siblings;

    {
        name = "John Doe";
        dob = "01/01/1900";
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "name = '" + name + '\'' + ", dob = '" + dob + '\'';
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        System.out.println(parent);
        System.out.println(child);
    }
}
