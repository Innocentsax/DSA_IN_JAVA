package dev.Innocent.Section5.KeywordsAndExpression;

public class FirstLastDigitSum {
    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(232));
    }
    public static int sumFirstAndLastDigit(int number){
        if(number < 0){
            return -1;
        }
        int result = 0;
        int lastDigit = number % 10;
        while(number > 0){
            int firstDigit = number;
            number /= 10;
            result = firstDigit + lastDigit;
        }
        return result;
    }
}