package dev.Innocent.Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 55, 66, 78};
        int target = 78;
        System.out.println(search(arr,target, 0, arr.length - 1));
    }
    static int search(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int middle = start + (end - start)/ 2;

        if(target == arr[middle]){
            return middle;
        }
        if(target < arr[middle]){
            return search(arr, target, start, end - 1);
        }
        return search(arr, target, start + 1, end);
    }
}
