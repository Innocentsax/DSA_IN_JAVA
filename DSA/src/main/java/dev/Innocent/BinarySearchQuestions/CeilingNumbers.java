package dev.Innocent.BinarySearchQuestions;

public class CeilingNumbers {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 1;
        System.out.println(floorNumber(arr, target));
    }
    // Return the smallest number greater or equal to target
    static int ceilingNumber(int[] arr, int target){
        // But what if the target is greater than the greatest number in the array
        if(target > arr[arr.length - 1]){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == arr[mid]){
                return mid;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else if(target < arr[mid]){
                end = mid - 1;
            }
            else{
                return mid;
            }
        }
        return start;
    }

    // Return the index of the greatest number <= target
    static int floorNumber(int[] arr, int target){
        // But what if the target is greater than the greatest number in the array
        if(target > arr[arr.length - 1]){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target > arr[mid]){
                start = mid + 1;
            }
            else if(target < arr[mid]){
                end = mid -1;
            }
            else {
                return mid;
            }
        }
        return end;
    }
}
