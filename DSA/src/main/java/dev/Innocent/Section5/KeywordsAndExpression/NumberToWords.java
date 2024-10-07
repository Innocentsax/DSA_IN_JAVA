package dev.Innocent.Section5.KeywordsAndExpression;

public class NumberToWords {
    public static void main(String[] args) {
        NumberToWords(123);
    }
    public static void NumberToWords(int number){
        if(number < 0){
            System.out.println("Invalid value");
        }else if(number == 0){
            System.out.println("Zero");
        }

        int reversedNumber = reverseNumbers(number);
        int totalDigit = getDigitCount(number);
        int counter = 0;

        while(reversedNumber != 0){
            int lastDigit = reversedNumber % 10;

            switch (lastDigit){
                case 0 -> System.out.println("Zero");
                case 1 -> System.out.println("One");
                case 2 -> System.out.println("Two");
                case 3 -> System.out.println("Three");
                case 4 -> System.out.println("Four");
                case 5 -> System.out.println("Five");
                case 6 -> System.out.println("Six");
                case 7 -> System.out.println("Seven");
                case 8 -> System.out.println("Eight");
                case 9 -> System.out.println("Nine");
            }
            reversedNumber = reversedNumber / 10;
            counter++;
        }
        if(totalDigit != counter && number == 0){
            for(int i = totalDigit - counter; i != 0; i++){
                System.out.println("Zero");
            }
        }
    }

    public static int reverseNumbers(int number){
        int reverseNumber = 0;
        while (number != 0){
            int lastDigit = number % 10;
            reverseNumber += lastDigit;
            reverseNumber = reverseNumber * 10;
            number /= 10;
        }
        return reverseNumber / 10;
    }

    public static int getDigitCount(int number){
        if(number < 0){
            return -1;
        }else if(number == 0){
            return 1;
        }
        int count;
        for (count = 0; number != 0; count++) {
            number /= 10;
        }
        return count;
    }
}