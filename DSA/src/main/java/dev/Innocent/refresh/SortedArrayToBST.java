package dev.Innocent.refresh;

import javax.swing.tree.TreeNode;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/?envType=problem-list-v2&envId=array
public class SortedArrayToBST {
    public static void main(String[] args) {
        System.out.println();
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

    }

    public TreeNode CreateBST(int[] nums, int l, int r){
        if(l > r){
            return null;
        }
        int mid = l + (r - l) / 2;
    }

}
