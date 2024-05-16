package dev.Innocent.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TargetArray {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }
    public static int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] result = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(index[i], nums[i]);
        }
        for (int i = 0; i < n; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}