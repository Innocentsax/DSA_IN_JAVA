package org.example.Functions.Functions_and_Method;

public class OverLoading {
    //When two function have the same function and data but different args.
    public static void main(String[] args) {
        fun("Innocent");

        int result = sum(23 , 5);
        int result2 = sum(34, 7, 90);
        System.out.println(result);
    }

    static int sum(int a, int b){
        return a + b;
    }

    static int sum(int a, int b, int c){
        return a + b + c;
    }
    static  void fun(int a){
        System.out.println(a);
    }

    static void fun(String name){
        System.out.println(name);
    }
}
