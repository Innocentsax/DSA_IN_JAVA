package dev.Innocent.SortingArrays.Questions;

import java.util.Arrays;

// https://leetcode.com/problems/first-missing-positive/
// Amazon
class SmallestPositiveInteger {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 56, 7};
        Arrays.toString(arr);
        System.out.println(firstMissingPositive(arr));
    }
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]){
                swap(nums, i, correct);
            }else {
                i++;
            }
        }
        // Search for first missing number
        for (int index = 0; index < nums.length; index++) {
            if(nums[index] != index + 1){
                return index + 1;
            }
        }
        return nums.length + 1;
    }

    static void swap(int[] nums, int i, int correct) {
        int temp = nums[i];
        nums[i] = nums[correct];
        nums[correct] = temp;
    }
}