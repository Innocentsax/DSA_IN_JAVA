package dev.Innocent.Assignment.Arrays;

import java.util.Arrays;

// https://leetcode.com/problems/build-array-from-permutation/
public class BuildArray {
    public static void main(String[] args) {
        int[] nums = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(buildArray2(nums)));
    }
    static int[] buildArray2(int[] nums){
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
