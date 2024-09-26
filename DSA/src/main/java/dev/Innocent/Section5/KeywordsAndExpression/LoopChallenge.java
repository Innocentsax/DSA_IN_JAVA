package dev.Innocent.Section5.KeywordsAndExpression;

public class LoopChallenge {
    public static void main(String[] args) {
        int evenCount = 0;
        int oddCount = 0;
        int number = 4;
        int finishedNumber = 20;
        while(number <= finishedNumber){
            number++;
            if(!isEvenNumber(number)){
                oddCount++;
                continue;
            }
            System.out.println(number);
            evenCount++;
            if(evenCount >= 5){
                break;
            }
        }
        System.out.println("This is even Number =" + evenCount);
        System.out.println("This is odd Number =" + oddCount);
    }
    public static boolean isEvenNumber(int number){
        if(number % 2 == 0){
            return true;
        }else{
            return false;
        }
    }
}
