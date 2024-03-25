package dev.Innocent.LinearSearch;

public class LinearSearch1 {
    public static void main(String[] args) {
        int[] nums = {23, 45, 1, 2, 8, 10, -3, 16, -11, 28};
        int target = 28;
        int ans = linearSearch(nums, target);
        System.out.println(ans);
    }
    // Search in the array: return the index if item found otherwise if the
    // item not found return -1
    static int linearSearch(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }
        // Run a for loop
        for (int i = 0; i < arr.length; i++) {
            // Check for element at every index if it is = target
            if(arr[i] == target){
                return arr[i];
            }
        }
        // This line will execute if none of the return statements above have executed,
        // hence the target not found
        return -1;
    }
}
