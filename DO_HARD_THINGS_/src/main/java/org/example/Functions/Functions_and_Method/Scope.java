package org.example.Functions.Functions_and_Method;

public class Scope {
    public static void main(String[] args) {
        int a = 10; // initialing
        int b = 20;
        String name = "Innocent";

        {
            a = 100; // updating
            System.out.println(a);
            name = "Charles";
            System.out.println(name);
        }
        System.out.println(a);
        System.out.println(name);
    }
}
// note: Any value that is initialize outside the block can be use inside the block,
// but any value that is initialize inside the  block can not be use outside
