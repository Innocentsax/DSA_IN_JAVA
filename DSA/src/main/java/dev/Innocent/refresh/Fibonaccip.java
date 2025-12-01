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
    public static long fibonacci1(int n){
        if(n <= 0) throw new IllegalArgumentException("n most be positive number");
        if(n == 1) return 0;
        if(n == 2) return 1;

        long first = 0, second = 1;
        for (int i = 3; i <= n; i++) {
            long result = first + second;
            first = second;
            second = result;
        }
        return second;
    }
}
