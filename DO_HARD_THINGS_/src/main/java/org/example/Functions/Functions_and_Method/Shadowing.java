package org.example.Functions.Functions_and_Method;

public class Shadowing {
    // Shadowing in Java is a practice of using two variables withe same name within the scope that overlabs
    static int x = 90; // this will be shadowed at line 10.

    public static void main(String[] args) {
        System.out.println(x); // 90
        int x = 40; // the class variable at line 5 is shadowed by this.
        System.out.println(x); // 40
        fun();
    }

    static void fun(){
        System.out.println(x);
    }
}
