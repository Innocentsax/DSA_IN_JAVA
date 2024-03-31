package dev.Innocent.BinarySearchQuestions;
// https://leetcode.com/problems/split-array-largest-sum/submissions/1219106019/
public class SplitArray {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }
    static int splitArray(int[] nums, int k){
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // In the end of the loop this will contain the max item from the array
            end += nums[i];
        }

        // Binary search
        while(start < end){
            // Try for the middle as potential ans
            int mid = start + (end - start) / 2;

            // calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for(int num : nums){
                if(sum + num > mid){
                    // You cannot add this in this subArray, make new one
                    // Say you add this num in new subArray, then sum = num
                    sum = num;
                    pieces++;
                }else{
                    sum += num;
                }
            }
            if(pieces > k){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start; // Here start == end;
    }
}
