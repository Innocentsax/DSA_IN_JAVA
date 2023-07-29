/*
Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
*/

class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int min = 1; int max = 1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]== 0){
                min = 1; max = 1;
                result = Math.max(result, nums[i]);continue;
            }
            int temp = min;
            min = Math.min(nums[i], Math.min(nums[i]* min, nums[i] * max));
            max = Math.max(nums[i], Math.max(nums[i] * temp, nums[i] * max));
            result = Math.max(result, max);
        }
        return result; // Time complexity = 0(n) ==> Space complexity = 0(1)
    }
}
