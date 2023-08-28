// Time Complexity : O(n)
// Space Complexity :O(h) recursive stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

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
    //Global pointers
    TreeNode curr;
    TreeNode prev;
    TreeNode first;
    TreeNode sec;
    public void recoverTree(TreeNode root) {

        //Recursive function
        dfs(root);
        //Swapping the value
        int temp = first.val;
        first.val = sec.val;
        sec.val = temp;

    }
    private void dfs(TreeNode root){
        //base
        if(root == null) return;

        //logic
        dfs(root.left);
        //Inorder traversal action
        prev = curr;
        curr = root;
        //Checking to see if we find first breach
        if(prev != null && first == null && curr.val < prev.val){
            first = prev;
            sec = curr;
        }
        //Checking to see if we find second breach
        if(prev != null && curr.val < prev.val) sec = curr;

        dfs(root.right);
    }
}