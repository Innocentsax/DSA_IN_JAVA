package dev.Innocent.Section5.KeywordsAndExpression;

public class SumOddRange {
    public static boolean isOdd(int number){
        if(number < 0){
            return false;
        }
        return number % 2 != 0;
    }
    
    public static int sumOdd(int start, int end){
        int result = 0;
        if (start < 0 || start > end) {
            return -1;
        }
        for(int i = start; i <= end; i++){
            if(i % 2 != 0){
                result += i;
            }
        }
        return result;
    }
}