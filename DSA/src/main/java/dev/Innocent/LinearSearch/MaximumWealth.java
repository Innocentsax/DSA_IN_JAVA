package dev.Innocent.LinearSearch;

public class MaximumWealth {
    public static void main(String[] args) {

    }
    public int maxWealth(int[][] accounts){
        int ans = Integer.MIN_VALUE;

        // person = rol
        // account = col

        for(int person = 0; person < accounts.length; person++){
            // when you start a new col, take a new sum for that row
            int sum = 0;
            for (int account = 0; account < accounts[person].length; account++) {
                sum = sum + accounts[person][account];
            }
            // now we have sum of the accounts of person, check with overall ans
            if(sum > ans){
                ans = sum;
            }
        }
        return ans;
    }

    public int maxWealth2(int[][] accounts){
        int ans = Integer.MIN_VALUE;

        // person = rol
        // account = col

        for (int[] ints : accounts) {
            // when you start a new col, take a new sum for that row
            int sum = 0;
            for (int anInt : ints) {
                sum = sum + anInt;
            }
            // now we have sum of the accounts of person, check with overall ans
            if (sum > ans) {
                ans = sum;
            }
        }
        return ans;
    }
}
