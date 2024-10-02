package dev.Innocent.Section5.KeywordsAndExpression;

public class SharedDigit {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 13));
    }
    public static boolean hasSharedDigit(int numberA, int numberB){
        if(numberA < 10 || numberA > 99 || numberB < 10 || numberB > 99){
            return false;
        }
        int originalNumberB = numberB;
        while(numberA > 0){
            int lastDigit = numberA % 10;
            numberA /= 10;

            numberB = originalNumberB;
            while(numberB > 0){
                if(lastDigit == numberB % 10){
                    return true;
                }
                numberB /= 10;
            }
        }
        return false;
    }
}

