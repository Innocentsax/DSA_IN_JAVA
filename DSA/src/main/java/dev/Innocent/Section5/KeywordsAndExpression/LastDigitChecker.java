package dev.Innocent.Section5.KeywordsAndExpression;

public class LastDigitChecker {
    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(41, 22, 71));
    }
    public static boolean hasSameLastDigit(int a, int b, int c){
        if(!isValid(a) || !isValid(b) || !isValid(c)){
            return false;
        }
        do{
            int lastDigitA = a % 10;
            int lastDigitB = b % 10;
            int lastDigitC = c % 10;

            return lastDigitA == lastDigitB || lastDigitB == lastDigitC || lastDigitC == lastDigitA;
        }while(a > 10 || b > 10 || c > 10);
    }
    public static boolean isValid(int number){
        return number >= 10 && number <= 1000;
    }
}