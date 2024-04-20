package dev.Innocent.Recursion;

public class Fibo {
    public static void main(String[] args) {
        System.out.println(fibFormula(50));
    }

    // Using the Formula
    static int fibFormula(int n){
        // Just for demo, use long instead
        return (int)(Math.pow(((1 + Math.sqrt(5)) / 2), n) / Math.sqrt(5));
    }

    static int fibo(int n){
        // Base condition
        if(n< 2){
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}
