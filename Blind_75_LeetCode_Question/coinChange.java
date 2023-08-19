/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
       int[] coinChange = new int[amount + 1];
       for (int i = 1; i <= amount; i++){
           int min = Integer.MAX_VALUE;
           for (int j = 0; j < coins.length; j++){
               if(i >= coins[j] && coinChange[i - coins[j]] != -1){
                   min = Math.min(min, coinChange[i - coins[j]]);
               }
           }
            coinChange[i] = (min == Integer.MAX_VALUE) ? -1 : 1 + min;
       } 
       return coinChange[amount];
    }
}
