package org.example.DSA;

import java.util.Scanner;

public class Day7 {
    public static void main(String[] args) {
//        int arr[] = {1, 2, 3, 4, 5};
//        for(int i = 0; i < arr.length; i++){
//            System.out.print(arr[i] + " ");
//        }for(int i = arr.length -1; i >= 0; i--){
//            System.out.print(arr[i] + " ");
//
//
//        }
//        System.out.println("====");
//        char alph = 'Z';
//        System.out.println((int) alph);
//        for (int i = arr.length; i > 0 ; i--) {
        //TODO: Input a number and print whether the number is a prime number or not
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scanner.nextInt();
        if (num % 2 == 0){
            System.out.println("Its an even number");
        }else{
            System.out.println("It's a prime number ");
        }

    }

}
