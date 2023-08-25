/*

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
