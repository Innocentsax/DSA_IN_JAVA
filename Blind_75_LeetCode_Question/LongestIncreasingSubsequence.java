/*
Given an integer array nums, return the length of the longest strictly increasing 
subsequence

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length; //length of all given array
        if(n == 1) return 1;
        int[] arr = new int[n];
        arr[0] = 1; // insert 1 as the base case
        int ans = 0;
        for(int i = 1; i<n; i++){
            int len = 0;
            for(int j = 0; j< i; j++){
                if(nums[j] < nums[i]){
                    len = Math.max(len, arr[j]);
                }
            }arr[i] = 1 +len;
            ans = Math.max(ans, arr[i]);
        }return ans;
    }
}
