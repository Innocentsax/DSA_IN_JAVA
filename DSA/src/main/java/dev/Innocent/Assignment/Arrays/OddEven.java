package dev.Innocent.Assignment.Arrays;

public class OddEven {
    public static void main(String[] args) {
        int n = 68;
        System.out.println(isOdd(n));
    }
    private static boolean isOdd(int n){
        return (n & 1) == 1;
    }
    private static int ithBit(int n){
        return n & (1 << (n - 1));
    }
}
