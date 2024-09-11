package dev.Innocent.Section5.KeywordsAndExpression;

public class TeenNumberChecker {
    public static void main(String[] args) {
        System.out.println(timeConversion(-1));
    }
    public static boolean hasTeen(int a, int b, int c){
        return isTeen(a) || isTeen(b) || isTeen(c);
    }
    
    public static boolean isTeen(int d){
        return d >= 13 && d <= 19;
    }

    public static double convertToCentimeter(int inches){
        return inches * 2.54;
    }

    public static double convertToCentimeter(int feet, int inches){
        return ((feet * 12) + inches) * 2.54;
    }

    public static double convertToCentimeter2(int feet, int inches){
        return convertToCentimeter((feet * 12) + inches);
    }

    public static String timeConversion(int seconds){
        if(seconds < 0) return "Invalid input";
        int minutes = seconds / 60;
       return timeConversion(seconds, minutes);
    }

    public static String timeConversion(int seconds, int minutes){
        if(seconds < 0 || seconds > 59){
            return "Invalid data";
        }
        if(minutes < 0){
            return "Invalid data";
        }

        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        int remainingSeconds = remainingMinutes % 60;

        return hours + " hrs " + remainingMinutes + " Mins " + remainingSeconds + " Secs ";
    }
}