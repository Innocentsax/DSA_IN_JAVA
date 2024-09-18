package dev.Innocent.Section5.KeywordsAndExpression;

public class Sum3and5Challenge {
    public static void main(String[] args) {
        int result = 0;
        int count = 0;
        for(int i = 1; count < 5 && i <= 1000; i++){
            if((i % 3 == 0) && (i % 5 == 0)){
                count++;
                result += i;
                System.out.println("Found a match " + i);
            }
        }
        System.out.println("Sum " + result);
    }
}
