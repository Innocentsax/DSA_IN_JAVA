package dev.Innocent.refresh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Merge {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        List<Integer> result = merge(nums1, m, nums2, n);
        System.out.println(result);
    }

    // https://leetcode.com/problems/merge-sorted-array/description/?envType=problem-list-v2&envId=array
    public static List<Integer> merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> merged = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            merged.add(nums1[i]);
        }

        for (int i = 0; i < n; i++) {
            merged.add(nums2[i]);
        }

        Collections.sort(merged);
        return merged;
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;        // Pointer for nums1 (end of valid elements)
        int j = n - 1;        // Pointer for nums2 (end)
        int k = m + n - 1;    // Pointer for placement in nums1 (end of total length)

        // Merge from the back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If nums2 still has elements left, copy them
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

}
