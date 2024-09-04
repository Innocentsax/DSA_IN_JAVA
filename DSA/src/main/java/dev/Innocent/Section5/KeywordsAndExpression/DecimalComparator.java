package dev.Innocent.Section5.KeywordsAndExpression;

public class DecimalComparator {
    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175));
    }
    public static boolean areEqualByThreeDecimalPlaces(double a, double b){
        return (int) (a * 1000) == (int) (b * 1000);
    }
}