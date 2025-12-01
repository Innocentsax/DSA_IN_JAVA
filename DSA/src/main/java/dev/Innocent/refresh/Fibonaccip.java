package dev.Innocent.refresh;

public class Fibonaccip {
    public static void main(String[] args) {
        printFibonacci(10);
        System.out.println("5th fib = " + fibonacci1(1));
    }

    // Shortcut
    public static int fibonacci(int n){
        if(n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // long cut
    // Return nth Fibonacci (1-indexed: F1=0, F2=1)
    public static long fibonacci1(int n){
        if(n <= 0) throw new IllegalArgumentException("n most be positive number");
        if(n == 1) return 0;
        if(n == 2) return 1;

        long first = 0;
        long second = 1;
        for (int i = 3; i <= n; i++) {
            long result = first + second;
            first = second;
            second = result;
        }
        return second;
    }

    public static void printFibonacci(int n){
        if(n <= 0) return;

        long first = 0;
        long second = 1;

        System.out.println(first);
        if(n == 1){
            System.out.println();
            return;
        }

        for (int i = 3; i <= n; i++) {
            long result = first + second;
            System.out.println();
            first = second;
            second = result;
        }
        System.out.println();
    }
}
