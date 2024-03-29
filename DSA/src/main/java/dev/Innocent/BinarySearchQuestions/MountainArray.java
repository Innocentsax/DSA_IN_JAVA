package dev.Innocent.BinarySearchQuestions;
// https://leetcode.com/problems/peak-index-in-a-mountain-array/
// https://leetcode.com/problems/find-peak-element/description/
public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {0,2,1,0};
        System.out.println(peakIndexInMountainArray(arr));
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
}
