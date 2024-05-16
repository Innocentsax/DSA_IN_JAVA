package dev.Innocent.LeetCode.Arrays;
// https://leetcode.com/problems/concatenation-of-array/description/

import java.util.Arrays;

public class ConcatenationOfArray {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(getConcatenation(nums)));
    }
    static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = nums.length; i < ans.length; i++) {
            ans[i - nums.length] = nums[i - nums.length];
            ans[i] = nums[i - nums.length];
        }
        return ans;
    }
}
