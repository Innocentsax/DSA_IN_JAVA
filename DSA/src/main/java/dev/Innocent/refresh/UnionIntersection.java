package dev.Innocent.refresh;

import java.util.HashSet;

public class UnionIntersection {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        findUnion(arr1, arr2);
    }

    public static void findUnion(int[] arr1, int[] arr2){
        HashSet<Integer> union = new HashSet<>();

        for(int num : arr1){
            union.add(num);
        }

        for(int num2 : arr2){
            union.add(num2);
        }

        System.out.print("Union element : " + union);
    }
}
