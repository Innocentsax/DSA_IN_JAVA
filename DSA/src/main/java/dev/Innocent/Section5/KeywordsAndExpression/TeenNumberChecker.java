package dev.Innocent.Section5.KeywordsAndExpression;

public class TeenNumberChecker {
    public static void main(String[] args) {
        System.out.println(hasTeen(9, 99, 19));
    }
    public static boolean hasTeen(int a, int b, int c){
        return isTeen(a) || isTeen(b) || isTeen(c);
    }
    
    public static boolean isTeen(int d){
        return d >= 13 && d <= 19;
    }
}