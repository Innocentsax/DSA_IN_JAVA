package dev.Innocent.LinearSearch;

public class EvenDigits {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(findNumber3(nums));
    }
    static int findNumbers(int[] nums){
        int count = 0;
        for(int num : nums){
            if(even(num)){
                count++;
            }
        }
        return count;
    }
    static boolean even(int num){
        int numberOfDigits = digits2(num);
//        if(numberOfDigits % 2 == 0){
//            return true;
//        }
//        return false;
        return numberOfDigits % 2 == 0;
    }

    // count number of digits in a number
    static int digits(int num){
        int count = 0;
        while(num > 0){
            count++;
            num = num / 10;
        }
        return count;
    }

    static int digits2(int num){
        if(num < 0){
            num = num * -1;
        }
        return (int)(Math.log10(num)) + 1;
    }

    static int findNumber2(int[] nums){
        int count = 0; // Initialize a counter variable to keep track of the count of numbers with even number of digits
        for(int num : nums){ // Iterate through each element of the nums array
            if((int)(Math.log10(num) + 1) % 2 == 0){ // Check if the number of digits in the current number is even
                count++; // If the number of digits is even, increment the counter
            }
        }
        return count; // Return the count of numbers with even number of digits
    }

    static int findNumber3(int[] nums){
        int count = 0; // Initialize a counter variable to keep track of the count of numbers with even number of digits
        for (int i = 0; i < nums.length; i++) {// Iterate through each element of the nums array using a normal for loop
            // Check if the current number nums[i] has an even number of digits
            if(nums[i] >= 10 && nums[i] < 100 || nums[i] >= 1000 && nums[i] < 9999 || nums[i] == 100000){
                count++; // If the number of digits is even, increment the counter
            }
        }
        return count; // Return the count of numbers with even number of digits
    }
}
