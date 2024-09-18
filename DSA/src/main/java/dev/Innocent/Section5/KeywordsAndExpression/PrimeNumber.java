package dev.Innocent.Section5.KeywordsAndExpression;

import java.util.regex.Pattern;

public class PrimeNumber {
    public static void main(String[] args) {
//        Pattern 1
        int count = 0;
        for(int i = 10; i <= 50; i++){
            if(isPrime(i)){
                System.out.println("Number " + i + " is a prime number");
                count++;
                if(count == 3){
                    System.out.println("Found 3 exiting loops");
                    break;
                }
            }
        }
        // Pattern 2
        int counts = 0;
        for(int i = 51; counts < 3 && i <= 100; i++){
            if(isPrime(i)){
                System.out.println("Number " + i + " is a prime number");
                counts++;
            }
        }
    }

    public static boolean isPrime(int wholeNumber){
        if(wholeNumber <= 2){
            return (wholeNumber == 2);
        }
        for(int divisor = 2; divisor <= wholeNumber / 2; divisor++){
            if(wholeNumber % divisor == 0){
                return false;
            }
        }
        return true;
    }
}
