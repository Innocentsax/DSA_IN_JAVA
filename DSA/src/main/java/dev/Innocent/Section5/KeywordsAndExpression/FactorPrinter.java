package dev.Innocent.Section5.KeywordsAndExpression;

public class FactorPrinter {
    public static void main(String[] args) {
        printFactorsII(6);
    }
    // Using method one
    public static void printFactors(int number){
        if(number < 1){
            System.out.println("Invalid Value");
        }
        int start = 1;
        while(start <= number){
            if(number % start == 0){
                System.out.println(start);
            }
            start++;
        }
    }

    // Using method two
    public static void printFactorsII(int number){
        if(number < 1){
            System.out.println("Invalid Value");
        }
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                System.out.print(i + " ");
            }
        }
    }
}