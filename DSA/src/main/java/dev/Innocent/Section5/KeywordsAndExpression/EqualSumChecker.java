package dev.Innocent.Section5.KeywordsAndExpression;

public class EqualSumChecker {
    public static void main(String[] args) {
        System.out.println(hasEqualSum(1, 1, 1));
    }
    public static boolean hasEqualSum(int a, int b, int c){
        return (a + b) == c;
    }
}