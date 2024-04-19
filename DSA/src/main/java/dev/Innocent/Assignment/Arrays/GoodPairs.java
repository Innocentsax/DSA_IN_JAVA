package dev.Innocent.Assignment.Arrays;

import java.util.Arrays;

class GoodPairs {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(numIdenticalPairs(nums));
    }
    public static int numIdenticalPairs(int[] nums) {
        int numberOfGoodPairs = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    numberOfGoodPairs++;
                }
            }
        }

        return numberOfGoodPairs;
    }
     public int numIdenticalPairs2(int[] nums) {
         int numberOfGoodPairs = 0;

         int[] sortedNums = Arrays.stream(nums).sorted().toArray();

         for (int i = 0; i < sortedNums.length; i++) {
             for (int j = i + 1; j < sortedNums.length; j++) {
                 if (nums[i] == nums[j]) {
                     numberOfGoodPairs++;
                 }
             }
         }

         return numberOfGoodPairs;
     }
}