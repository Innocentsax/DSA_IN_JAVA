package dev.Innocent.Section5.KeywordsAndExpression;

public class PositiveNegativeZero {
    public static void checkNumber(int number){
        System.out.println((number > 0) ? "positive" : ((number < 0) ? "negative" : "zero"));
    }
}