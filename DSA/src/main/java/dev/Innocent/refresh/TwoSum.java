package dev.Innocent.refresh;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/description/?envType=problem-list-v2&envId=array
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSumPractices(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // currentNo + x = target
            // x = target - currentNo
            int x = target - nums[i];
            if(map.containsKey(x)){
                return new int[] {map.get(x), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            // firstNo + num[x] = target
            // num[x] = target - firstNo
            for (int j = 1; j < nums.length; j++) {
                if(nums[j] == target - nums[i]){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSumPractices(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j < nums.length; j++){
                if(nums[j] == target - nums[i]){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public String reverseString(String s) {
        if (s == null) return null;
        if (s.length() <= 1) return s;

        return new StringBuilder(s).reverse().toString();
    }

    public String reverseString1(String s) {
        if (s == null) return null;
        if (s.length() <= 1) return s;

        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        return new String(chars);
    }

}
