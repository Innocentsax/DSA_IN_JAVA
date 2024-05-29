package dev.Innocent.LeetCode.Arrays;

class MinCostToMoveChips {
    public static void main(String[] args) {
        int[] position = {1,2,3};
        System.out.println(minCostToMoveChips(position));
    }
    public static int minCostToMoveChips(int[] position) {
        int eventCount = 0;
        int oldCount = 0;

        // Count the number of chips at even and odd positions
        for(int pos : position){
            if(pos % 2 == 0){
                eventCount++;
            }
            oldCount++;
        }
        // The minimum cost to move all chips to the same position
        return Math.min(eventCount, oldCount);
    }
}