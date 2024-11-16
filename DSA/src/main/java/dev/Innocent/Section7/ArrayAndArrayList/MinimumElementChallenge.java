package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElementChallenge {
    public static void main(String[] args) {
        int[] returnArray = readInteger();
        System.out.println(Arrays.toString(returnArray));

        int returnMin = findMin(returnArray);
        System.out.println("Min = " + returnMin);
    }

    private static int[] readInteger(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a list of Integers, separated by comma: ");
        String input  = scanner.nextLine();

        String[] splits = input.split(",");
        int[] values = new int[splits.length];

        for (int i = 0; i < splits.length; i++) {
            values[i] = Integer.parseInt(splits[i].trim());
        }
        return values;
    }

    private static int findMin(int[] array){
        int min = Integer.MAX_VALUE;
        for(int num : array){
            if(num < min){
                min = num;
            }
        }
        return min;
    }
}
