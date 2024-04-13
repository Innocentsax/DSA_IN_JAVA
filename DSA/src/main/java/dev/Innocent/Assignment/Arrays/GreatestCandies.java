package dev.Innocent.Assignment.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
class GreatestCandies {
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(Arrays.toString(new List[]{kidsWithCandies(candies, extraCandies)}));

    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatestCandy = 0;
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            if(candies[i] > greatestCandy){
                greatestCandy = candies[i];
            }
        }

//        Arrays.sort(candies);
//        greatestCandy = candies[candies.length -  1];
//        System.out.println(greatestCandy);
        for (int i = 0; i < candies.length; i++) {
            if(candies[i] + extraCandies >= greatestCandy){
                result.add(true);
            }else {
                result.add(false);
            }
        }
        return result;
    }

    public static List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {
        int greatestCandy = 0;
        List<Boolean> result = new ArrayList<>();

        for (int candy : candies) {
            if (candy > greatestCandy) {
                greatestCandy = candy;
            }
        }

//        Arrays.sort(candies);
//        greatestCandy = candies[candies.length -  1];
//        System.out.println(greatestCandy);
        for (int candy : candies) {
            if (candy + extraCandies >= greatestCandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}