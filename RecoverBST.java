// Time Complexity : O(N)- worst case we need to traverse every node
// Space Complexity : O(N) - Internal stack as we use recursive approach 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
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
    TreeNode first,second,prev;
    public void recoverTree(TreeNode root) {
        helper(root);
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    public void helper(TreeNode root){
        if(root != null){
            helper(root.left);
            if(prev != null && root.val < prev.val){
                if(first == null){
                    first = prev;
                    second = root;
                }
                else{
                    second = root;
                }
            }
            prev = root;
            helper(root.right);
        }
    }
}

// Your code here along with comments explaining your approach
