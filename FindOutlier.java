/*
You are given an array (which will have a length of at least 3, but could be 
very large) containing integers. The array is either entirely comprised of odd integers or 
entirely comprised of even integers except for a single integer N. Write a method that takes the 
array as an argument and returns this "outlier" N.

Specification
FindOutlier.find(integers)
Parameters
integers: Integer[]

Return Value
Integer - The only odd or even number
*/



import java.util.ArrayList;

public class FindOutlier {
    public static int findOutlier(ArrayList<Integer> integers) {
        int oddCount = 0;
        int evenCount = 0;
        int oddNumber = 0;
        int evenNumber = 0;

        // Count the number of odd and even integers
        for (int num : integers) {
            if (num % 2 == 0) {
                evenCount++;
                evenNumber = num;
            } else {
                oddCount++;
                oddNumber = num;
            }
        }

        // Determine the majority (odd or even)
        if (oddCount == 1) {
            // If there is only one odd number, return it
            return oddNumber;
        } else {
            // If there is only one even number, return it
            return evenNumber;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(4);
        list1.add(6);
        list1.add(8);
        list1.add(10);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(5);
        list2.add(7);
        list2.add(9);
        list2.add(10);

        System.out.println(findOutlier(list1)); // Output: 3
        System.out.println(findOutlier(list2)); // Output: 10
    }
}
