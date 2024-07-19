/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Time Complexity : O(n)
// Space Complexity : O(h) recursive space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    TreeNode prev;
    TreeNode first, second;
    int count;
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root);
        //swapping values
        int temp = first.val; 
        first.val = second.val;
        second.val = temp;
        
    }

    private void inorder(TreeNode root) {
        if (root == null || count == 2) {
            return;
        }
        inorder(root.left); // go left
        if (prev != null && prev.val > root.val) {
            count++; // to prevent the code to run multiple times even after getting required values
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root; // setting prev to curr as cur has gone ahead with recursion
        inorder(root.right); // go right
    }
}