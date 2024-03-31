package dev.Innocent.BinarySearchQuestions;

import java.util.Arrays;

// Given an array of size n and an integer X. Find if there's a triplet in the array which
// sums up to the given integer.
public class TripletSumInArray {
    public static void main(String[] args) {
        int[] A = {1, 4, 45, 6, 10, 8};
        int n = 6;
        int X = 13;
        System.out.println(tripletSumInArray2(A, n, X));
    }

    // First approach
    static boolean tripletSumInArray(int[] A, int n, int X){
        if(n < 3){
            return false;
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if(A[i] + A[j] + A[k] == X){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Second approach
    static boolean tripletSumInArray2(int[] A, int n, int X){
        if(n < 3){
            return false;
        }

        Arrays.sort(A);

        for (int first = 0; first < n - 1; first++) {
            int second = first + 1;
            int third = n - 1;

            while(second < third){
                if(A[first] + A[second] + A[third] ==  X){
                    return true;
                }
                else if(A[first] + A[second] + A[third] < X){
                    second++;
                }
                else{
                    third--;
                }
            }
        }
        return false;
    }
}
