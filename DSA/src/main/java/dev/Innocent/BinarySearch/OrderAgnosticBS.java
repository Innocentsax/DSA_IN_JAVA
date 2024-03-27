package dev.Innocent.BinarySearch;

public class OrderAgnosticBS {
    public static void main(String[] args) {
//        int[] arr = {-19, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89}; // Ascending
        int[] arr = {99, 80, 75, 22, 11, 10, 5, 2, -3}; // Descending
        int target = 22;
        System.out.println(orderAgnosticBS(arr, target));
    }
    static int orderAgnosticBS(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end]; // check if the array is an ascending or descending mode

        while(start <= end){
            // Find the middle element
//            int mid = (start + end) / 2; might be possible that(start + end) exceeds the range of int in Java
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return mid;
            }

            if(isAsc){ // For ascending
                if(target < arr[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }else{ // for descending
                if(target > arr[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
