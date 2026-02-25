package dev.Innocent.refresh;

import java.util.HashSet;

public class FindDuplicate {

    public static void main(String[] args) {
        int[] numbers = {4, 2, 7, 4, 8, 2, 9, 7};

        findDuplicate(numbers);
    }

    private static void findDuplicate(int[] arr){
        HashSet<Integer> orig = new HashSet<>();
        HashSet<Integer> dup = new HashSet<>();

        for(int num : arr){
            if(!orig.add(num)){
                dup.add(num);
            }
        }

        System.out.println(dup);
    }

    // Remove Duplicate without Set
    public static int[] removeDuplicates(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < index; j++) {
                if (arr[i] == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                temp[index++] = arr[i];
            }
        }
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        return result;
    }
}
