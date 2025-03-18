// Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

// Time Complexity : O(n) 
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here take prev, first and last treenodes as global and a global flag. Call helper function which does inorder traversal with logic
 * of finding a mismatch case where root.val is less than prev.val, if yes and flag is false set first to prev and last to root else last
 * to root. Change prev to root and do right recursion. Swap the first and last values.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode last;
    boolean flag;

    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    private void helper(TreeNode root){
        //base
        if(root == null) return;
        //logic
        helper(root.left);
        if(prev != null && root.val<prev.val){
            if(!flag){
                flag = true;
                first = prev;
                last = root;
            }
            else{
                last = root;
            }

        }
        prev = root;
        helper(root.right);
    }
}