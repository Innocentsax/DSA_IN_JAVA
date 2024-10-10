package dev.Innocent.Section5.KeywordsAndExpression;

public class LargestPrime {
    public static void main(String[] args) {
        System.out.println(getLargestPrime(23));
    }
    public static int getLargestPrime(int number){
        if(number < 2){
            return -1;
        }
        for (int i = number / 2; i > 1 ; i--) {
            if(number % i == 0){
                number = i;
            }
        }
        return number;
    }
}