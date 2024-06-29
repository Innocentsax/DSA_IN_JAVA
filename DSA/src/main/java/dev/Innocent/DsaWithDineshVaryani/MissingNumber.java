package dev.Innocent.DsaWithDineshVaryani;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 8, 6, 3, 7};
        System.out.println(findMissingNumber(arr));
    }

    private static int missingNumber(int[] arr){
        int n = arr.length + 1; // Length of the arr + the missing number
        int sum = n * (n + 1)/2; // Find the sum of n natural numbers
        for(int num : arr){ // Check for every item in the arr and subtract it from the sum
            sum -= num;
        }
        return sum;
    }

    private static int findMissingNumber(int[] arr){
        int n = arr.length + 1;
        int sum = n * (n + 1)/2;
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
        }
        return sum;
    }
}
