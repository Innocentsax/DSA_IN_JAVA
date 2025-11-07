package dev.Innocent.refresh;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/description/?envType=problem-list-v2&envId=array
public class PascalTriangle {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if(numRows <= 0) return triangle;

        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    row.add(1);
                }else {
                    int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(val);
                }
            }
        }
        return null;
    }
}
