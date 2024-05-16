package dev.Innocent.LeetCode.Arrays;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
class SmallerThanCurrentNumber {
    public static void main(String[] args) {
       int[] nums = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = nums.clone();
        Arrays.sort(result);
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < result.length; i++) {
            index.putIfAbsent(result[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            result[j] = index.get(nums[j]);
        }
        return result;
    }
}