package dev.Innocent.Section5.KeywordsAndExpression;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputCalculator {
    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        long avg = 0;
        int loopCount = 0;

        while (true){
            System.out.println("Enter any number, or any character to exist: ");
            int nextEntry = 0;
            try{
                nextEntry = scanner.nextInt();
            }catch(NoSuchElementException e){
                scanner.nextLine();
                break;
            }
            sum += nextEntry;
            loopCount++;
        }
        scanner.close();

        if (loopCount > 0) {
            avg = Math.round((double) sum / loopCount);
        }
        System.out.println("SUM = " + sum + " AVG = " + avg);
    }
}