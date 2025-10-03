package dev.Innocent.Intro;

public class ArmstrongCheck {
    public static void main(String[] args) {
        int number = 243;
        int original = number;
        int result = 0;
        int digits = String.valueOf(number).length();

        while (number > 0){
            int digit = number % 10;
            result += Math.pow(digit, digits);
            number /= 10;
        }

        if(result == original){
            System.out.println(original + " is Armstrong number");
        }else {
            System.out.println(original + " is not a Armstrong number");
        }
    }


}
