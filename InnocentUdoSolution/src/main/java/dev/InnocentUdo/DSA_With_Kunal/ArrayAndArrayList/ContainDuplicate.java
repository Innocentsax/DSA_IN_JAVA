package dev.InnocentUdo.DSA_With_Kunal.ArrayAndArrayList;

import java.util.HashSet;
import java.util.Set;

// Given an integer array nums, return true if any value appears at
// least twice in the array, and return false if every element is distinct.
public class ContainDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containDuplicate(nums));
    }

    //Time complexity O(n) and Space complexity O(n)
    public static boolean containDuplicate(int[]  nums){
        Set<Integer> uniqueNumber = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(uniqueNumber.contains(nums[i])){
                return true;
            }uniqueNumber.add(nums[i]);
        }
        return false;
    }

    public static boolean containDuplicate2(int[] nums){

        return false;
    }
}
