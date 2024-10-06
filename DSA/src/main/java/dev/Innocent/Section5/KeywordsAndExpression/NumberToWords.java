package dev.Innocent.Section5.KeywordsAndExpression;

public class NumberToWords {
    public static void NumberToWords(int number){
        if(number < 0){
            System.out.println("Invalid value");
        }

        while(number > 9){
            int lastDigit = number % 10;
            number /= 10;
        }
    }
}