package dev.Innocent.Section5.KeywordsAndExpression;

public class MinutesToYearsDaysCalculator {
    public static void main(String[] args) {
        printYearsAndDays(56);
    }
    public static void printYearsAndDays(long minutes){
        if(minutes<0){
            System.out.println("Invalid Value");
        }else{
        long years = minutes / 525600;
        long days = (minutes % 525600) / 1440;
        
        System.out.println(minutes + " min = " + years + " y and " + days + " d");
        }
    }
}