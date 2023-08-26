package org.example.DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3 {
    static int min;
    static int max;
    static List<Character> characters;
    public static void main(String[] args) {
        List<Integer> listOfInteger = Arrays.asList(26, 56, 78, 35, 2, 9, 3, -9, 25, 10);
        //System.out.println(getMinAndMax(listOfInteger));
        Day3 testAlgo = new Day3();
        getMinAndMax(listOfInteger);
        System.out.println("Max value: " + max + " Min value: " + min);

        FindNumbersDivisibleBy5(listOfInteger);

        getAllAlphabet(characters);
    }
    public static void weird(int N){
        //if N is odd, print weird
        if (N % 2 != 0){
            System.out.println("Weird");
        }else if(N % 2 == 0 && N >= 2 && N <= 5){
            System.out.println("Not Weird");
        }else if(N % 2 == 0 && N >= 6 && N <= 20){
            System.out.println("Weird");
        }else if(N % 2 == 0 && N>20){
            System.out.println("Not Weird");
        }

        Number[] numbers = {10, 5, 8, -3, 15, 2.5};
        FindMinMax(numbers);
    }
    // Problem: Find the Max and Min number in an array of Number
   public static void FindMinMax(Number[] numbers){
        if(numbers == null || numbers.length == 0){
            System.out.println("Array is Empty");
        }
        Number min = numbers[0]; Number max = numbers[0];

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i].doubleValue() < numbers[i].doubleValue()){
                min = numbers[i];
            }if (numbers[i].doubleValue() > max.doubleValue()){
                max = numbers[i];
            }
        }
        System.out.println("Minimum number: " + min);
        System.out.println("Maximum number: " + max);

    }

    // Using an ArrayList
    public static void getMinAndMax(List<Integer> listOfNumber){
        for(int i = 0; i< listOfNumber.size(); i++){
            if(i == 0){
                min = listOfNumber.get(0);
                max = listOfNumber.get(0);
            }
            if(listOfNumber.get(i) > max){
                max = listOfNumber.get(i);
            }if(listOfNumber.get(i) < min){
                min = listOfNumber.get(i);
            }
        }
    }
    public static void FindNumbersDivisibleBy5(List<Integer> listOfInteger){
        //Integer number[] = new Integer[0];
        for(int i = 0; i < listOfInteger.size(); i++){
            if (listOfInteger.get(i) % 5 == 0){
                System.out.print(listOfInteger.get(i) + " ");
            }
        }
    }
    /*Problem: Find alphabets that are within A-G from a list of Alphabet-character.
    List<Character> listOfAlphabets = Arrays.asList('a','r', 'w', 'u', 'e', 'c', 'g');  */
    public static void getAllAlphabet(List<Character> listOfCharacter){
        characters = new ArrayList<Character>();
        List<Character> listOfA_G = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g');
        for (int i = 0; i <listOfCharacter.size(); i++){
            if(listOfA_G.contains(listOfCharacter.get(i))){
                characters.add(listOfCharacter.get(i));
            }
        }
    }
    public static void practiceForLoop(int x){

        for (int i = 1; i < x; i++){
            int mul = x * i;
            System.out.println(x + " x " + i + " = " + mul);
        }
    }

}
