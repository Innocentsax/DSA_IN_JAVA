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

    public static double convertToCentimeter(int inches){
        return inches * 2.54;
    }

    public static double convertToCentimeter(int feet, int inches){
        return ((feet * 12) + inches) * 2.54;
    }

    public static double convertToCentimeter2(int feet, int inches){
        return convertToCentimeter((feet * 12) + inches);
    }
}