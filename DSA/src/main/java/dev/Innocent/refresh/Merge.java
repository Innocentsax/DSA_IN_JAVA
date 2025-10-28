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
}
