package dev.Innocent.BinarySearchQuestions;
// https://leetcode.com/problems/find-in-mountain-array/description/
public class SearchInMountain {

    public static void main(String[] args) {

    }
    static int search(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);
        int start = orderAgnosticBS(arr, target, 0, peak);
        if(start != -1){
            return start;
        }
        // Try to search in Second half
        return orderAgnosticBS(arr, target, peak+1, arr.length - 1);
    }
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid + 1]){
                // You are in the descending part of array and this may be the answer
                // and this is why end != mid - 1
                end = mid;
            }else{
                // You are in the ascending part of the array
                start = mid + 1; // Because we know that mid + 1 element > mid element
            }
        }
        /* In the end, start == end and pointing to the largest number because of the 2 check above
         Start and end are always trying to find max element in the above checks, hence when there
         are pointing to just one element, that is the max one because that's what the check says.
         MORE ELABORATION: At every point in time for start and end, they have the possible answer till that time.
         So, if we are saying that only one item is remaining, hence, cause of the above, that's the best possible answer.
         */
        return start; // You can return start or end as both are equal.
    }

    static int orderAgnosticBS(int[] arr, int target, int start, int end){
//        int start = 0;
//        int end = arr.length - 1;

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

