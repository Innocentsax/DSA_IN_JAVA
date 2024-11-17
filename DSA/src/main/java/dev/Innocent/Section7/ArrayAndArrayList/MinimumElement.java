package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.Scanner;

public class MinimumElement {
    public static void main(String[] args) {
        int count = readInteger();
        int[] array = readElements(count);
        int min = findMin(array);
        System.out.println("They min number is " + min);
    }

    // Method to read an integer from the User
    public static int readInteger(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of element: ");
        return scanner.nextInt();
    }

    public static int[] readElements(int count){
        Scanner scanner = new Scanner(System.in);
        int[] elements = new int[count];

        System.out.println("Enter " + count + " integers");
        for (int i = 0; i < count; i++) {
            elements[i] = scanner.nextInt();
        }
        return elements;
    }

    public static int findMin(int[] array){
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    private static void reverse(int[] array){
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;

        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
    }

    private static int[] reverseCopy(int[] array){
        int[] reversedArray = new int[array.length];
        int maxIndex = array.length;
        for(int el : array){
            reversedArray[maxIndex--] = el;
        }
        return reversedArray;
    }
}
