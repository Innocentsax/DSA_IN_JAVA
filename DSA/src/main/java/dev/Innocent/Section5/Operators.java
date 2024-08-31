package dev.Innocent.Section5;

public class Operators {
    public static void main(String[] args) {
        double value = 20.00;
        double value2 = 80.00;
        double result = (value + value2) * 100;
        double newResult = result % 40.00;
        boolean isTrue = (newResult == 0) ? true : false;
        System.out.println("isTrue " + true);
        if(!isTrue){
            System.out.println("Got some reminder");
        }
    }
}
