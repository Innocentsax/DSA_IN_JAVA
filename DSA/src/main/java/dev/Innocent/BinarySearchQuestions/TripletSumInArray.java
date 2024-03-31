package dev.Innocent.BinarySearchQuestions;
// Given an array of size n and an integer X. Find if there's a triplet in the array which
// sums up to the given integer.
public class TripletSumInArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int n = 6;
        int X = 13;
        System.out.println(tripletSumInArray(arr, n, X));
    }
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
}
