package dev.Innocent.Section5.KeywordsAndExpression;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(25, 15));
    }
    public static int getGreatestCommonDivisor(int first, int second){
        if(first < 10 || second < 10){
            return -1;
        }
        // Find the smallest Number
        int temp = 0;
        if(first > second){
            temp = first;
            first = second;
            second = temp;
        }

        int gcd = 0;
        for (int i = 1; i <= first; i++){
            if(first % i == 0 && second % i == 0){
                gcd = i;
            }
        }
        return gcd;
    }
}