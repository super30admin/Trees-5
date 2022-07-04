//https://leetcode.com/problems/recover-binary-search-tree/
// Time Complexity :O(n)  
// Space Complexity :O(h) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
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
    TreeNode first; //first mismatch
    TreeNode second; //sec mismatch
    TreeNode prev;
    boolean firstflag;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    private void inorder(TreeNode root)
    {
        //base
        if(root==null)
            return;
        //logic
        inorder(root.left);
        if(prev!=null && prev.val>=root.val){ //when prev val is greater than or equal next val mismatch
        if(!firstflag){ //during the first mismatcb
            first=prev;
            second=root;
            firstflag=true;
        }
        else{ //second mismatch when mismatches are not consequtive
            second=root;
            return; //no need to recurse further as both the mismatches are found
        }
        }
        prev=root;
        inorder(root.right);
        
    }
}