package dev.Innocent.Section5.KeywordsAndExpression;

public class SpeedConverter {

    public static void main(String[] args) {
        printConversion(0);
    }

    public static long toMilesPerHour(double kilometersPerHour){
        long result;
        if(kilometersPerHour < 0){
            return -1;
        }else {
            result = Math.round(kilometersPerHour / 1.609);
        }
        return result;
    }

    public static void printConversion(double kilometersPerHour){
        if(kilometersPerHour < 0){
            System.out.println("Invalid Value");
        }
        System.out.println(kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h");
    }
}