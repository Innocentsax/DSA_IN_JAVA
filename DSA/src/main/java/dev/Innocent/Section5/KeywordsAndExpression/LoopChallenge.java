package dev.Innocent.Section5.KeywordsAndExpression;

public class LoopChallenge {
    public static void main(String[] args) {
        int number = 4;
        int finishedNumber = 20;
        while(number <= finishedNumber){
            number++;
            if(!isEvenNumber(number)){
                continue;
            }
            System.out.println(number);
        }
    }
    public static boolean isEvenNumber(int number){
        if(number % 2 == 0){
            return true;
        }else{
            return false;
        }
    }
}
