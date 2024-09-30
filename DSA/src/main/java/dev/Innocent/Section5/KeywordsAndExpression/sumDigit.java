package dev.Innocent.Section5.KeywordsAndExpression;

public class sumDigit {
    public static void main(String[] args) {
        System.out.println(sumDigits(1234));
    }
    private static int sumDigits(int number){
        int sum = 0;
        if(number < 0){
            return -1;
        }
        while(number > 9){
            sum += number % 10;
            number = number / 10;
        }
        sum += number;
        return sum;
    }
}
