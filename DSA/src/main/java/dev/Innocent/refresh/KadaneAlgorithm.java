package dev.Innocent.refresh;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] numbers = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxSum = maxSubArraySum(numbers);
        System.out.println("Maximum subarray sum: " + maxSum);
    }

    // Method to find the maximum subarray sum
    public static int maxSubArraySum(int[] arr){
        int maxSoFar = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        return maxSoFar;
    }
}
