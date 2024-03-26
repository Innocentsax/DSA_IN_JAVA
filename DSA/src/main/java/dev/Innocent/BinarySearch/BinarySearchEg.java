package dev.Innocent.BinarySearch;

public class BinarySearchEg {
    public static void main(String[] args) {
        int[] arr = {-19, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int target = 22;
        System.out.println(binarySearch(arr, target));
    }
    // Return the index
    // return -1 if it does not exist
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            // Find the middle element
//            int mid = (start + end) / 2; might be possible that(start + end) exceeds the range of int in Java
            int mid = start + (end - start) / 2;
            if(target < arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else {
                // answer found
                return mid;
            }
        }
        return -1;
    }
}
