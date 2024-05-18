package dev.Innocent.LeetCode.Arrays;

// https://leetcode.com/problems/maximum-population-year/description/

class MaximumPopulation {
    public static void main(String[] args) {
        int[][] logs = {{1993,1999},{2000,2010}};
        System.out.println(maximumPopulation1(logs));
    }
    public static int maximumPopulation(int[][] logs) {
        int[] year = new int[2051];
        for(int[] log : logs){
            year[log[0]] += 1;
            year[log[1]] -= 1;
        }
        int maxNum = year[1950], maxYear = 1950;
        for (int i = 1951; i < year.length; i++) {
            year[i] += year[i - 1];
            if(year[i] > maxNum){
                maxNum = year[i];
                maxYear = i;
            }
        }
        return maxYear;
    }

    public static int maximumPopulation1(int[][] logs){
        // Initialize an array to keep track of the population changes
        int[] populationChanges = new int[101];

        // Update the population
        for(int[] log : logs){
            int birthYear = log[0];
            int deadYear = log[1];
            populationChanges[birthYear - 1950]++; // 43
            populationChanges[deadYear - 1950]--; // 49
        }

        // Compute cumulative population
        int maxPopulation = 0;
        int maxYear = 1950;
        int currentPopulation = 0;

        for (int year = 0; year < 101; year++) {
            currentPopulation += populationChanges[year];
            if(currentPopulation > maxPopulation){
                maxPopulation = currentPopulation;
                maxYear = 1950 + year;
            }
        }
        return maxYear;
    }
}