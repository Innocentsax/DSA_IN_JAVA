package dev.Innocent.Section5.KeywordsAndExpression;

public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(isPerfectNumber(-1));
    }
    public static boolean isPerfectNumber(int number){
        if(number < 1){
            return false;
        }
        int perfectNumber = 0;
        for(int i = 1; i < number; i++){
            if(number % i == 0){
                perfectNumber += i;
            }
        }
        return perfectNumber == number;
    }
}