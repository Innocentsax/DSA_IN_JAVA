package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.Scanner;

public class SortedArray {
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
              System.out.printf("Element %d contents %d%n", i, array);
          }
      }
}