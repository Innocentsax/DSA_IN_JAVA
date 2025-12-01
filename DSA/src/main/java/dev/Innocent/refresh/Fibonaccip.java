package dev.Innocent.refresh;

public class Fibonaccip {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    // Shortcut
    public static int fibonacci(int n){
        if(n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // long cut
//    public
}
