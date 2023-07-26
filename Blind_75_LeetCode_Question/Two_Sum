class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                ans[0] = i;
                ans[1] = map.get(diff);
            }else{
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
