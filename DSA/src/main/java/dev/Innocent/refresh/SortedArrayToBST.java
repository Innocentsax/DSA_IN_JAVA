package dev.Innocent.refresh;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/?envType=problem-list-v2&envId=array
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        printPreorder(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return CreateBST(nums, 0, nums.length - 1);
    }

    public static TreeNode CreateBST(int[] a, int l, int r){
        if(l > r){
            return null;
        }

        // so basically in this question we have to convert sorted array to height
        // balanced tree
        // so if we directly create tree in given sorted order it will become linked
        // list
        // so we have to take middle element as head value such it will become height
        // balanced tree

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(a[mid]);
        root.left = CreateBST(a, l, mid - 1);
        root.right = CreateBST(a, mid + 1, r);

        return root;
    }

    static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

}
