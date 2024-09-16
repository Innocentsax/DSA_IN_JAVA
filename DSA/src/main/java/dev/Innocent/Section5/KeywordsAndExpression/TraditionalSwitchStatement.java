package dev.Innocent.Section5.KeywordsAndExpression;

public class TraditionalSwitchStatement {
    public static void main(String[] args) {
        char charValue = 'K';
        switch (charValue){
            case 'A':
                System.out.println("A is Able");
                break;
            case 'B':
                System.out.println("B is Baker");
                break;
            case 'C':
                System.out.println("C is Charlie");
                break;
            case 'D':
                System.out.println("D is dog");
                break;
            case 'E':
                System.out.println("E is Easy");
                break;
            default:
                System.out.println("Invalid input");
                break;
        }

        printDayOfWeek(2);
    }

    public static void printDayOfWeek(int day){
        String dayOfWeek = switch (day){
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid Statement";
        };
        System.out.println(day + " stand for " + dayOfWeek);
    }
}
