package dev.Innocent.BinarySearchQuestions;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/description/
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest2(nums, target));
    }
    // Brute Force Approach but did not work
    static int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int  j = i + 1;  j < nums.length - 1;  j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if( sum == target){
                        return sum;
                    }else if(sum < target){
                        j++;
                    }else{
                        k++;
                    }
                }
            }
        }
        return -1;
    }

    static int threeSumClosest2(int[] nums, int target){

        // Sort the elements
        Arrays.sort(nums);
        int resultSum = nums[0] + nums[1] + nums[2];
        int minDifference = Integer.MAX_VALUE;

        // Now fix the first element and find the other two elements
        for (int first = 0; first < nums.length - 2; first++) {
            // Find other two elements using two sum approach
            int second = first + 1;
            int last = nums.length - 1;

            while(second < last){
                int sum = nums[first] + nums[second] + nums[last];
                if(sum == target){
                    return sum;
                } else if (sum < target) {
                    second++;
                }else{
                    last--;
                }
                int differentFromTarget = Math.abs(sum - target);
                if(differentFromTarget < minDifference){
                    // Update the result sum
                    resultSum = sum;
                    minDifference = differentFromTarget;
                }
            }
        }
        return resultSum;
    }
}
