package dev.Innocent.Section5.KeywordsAndExpression;

public class NumberPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }
    public static boolean isPalindrome(int number){
        int reverse = 0;
        int original = number;
        while(number != 0){
            int lastDigits = number % 10;
            reverse = (reverse * 10) + lastDigits;
            number /= 10;
            System.out.println(reverse);
        }
        return (reverse == original);
    }
}