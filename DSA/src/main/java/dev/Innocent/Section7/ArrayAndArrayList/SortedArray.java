package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {
    public static void main(String[] args) {
        System.out.println(getIntegers(10));
    }
      public static int[] getIntegers(int size){
          Scanner scanner = new Scanner(System.in);
          int[] array = new int[size];
          int index = 0;

          while (index < size){
              System.out.printf("Please enter [%d] ", index);
              if(scanner.hasNextInt()){
                  array[index] = scanner.nextInt();
                  index++;
              }else{
                  System.out.println("Invalid Input");
                  scanner.next();
              }
          }
          return array;
      }

      public static void printArray(int[] array){
          for (int i = 0; i < array.length; i++) {
              System.out.printf("Element %d contents %d%n", i, array[i]);
          }
      }

      public static int[] sortIntegers(int[] array){
          int[] sortArray = array.clone();
          int[] reverseArray = new int[array.length];
          Arrays.sort(sortArray);
          int reverseIndex = 0;
          for(int i = sortArray.length - 1; i >= 0; i--){
              reverseArray[reverseIndex] = sortArray[i];
              reverseIndex++;
          }
          return reverseArray;
      }
}