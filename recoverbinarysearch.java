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
/*
Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution {
    TreeNode prev = null;
    TreeNode one = null;
    TreeNode two = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = one.val;
        one.val = two.val;
        two.val = temp;
    }
    public void inorder(TreeNode curr) {
        if(curr == null) {
            return;
        }
        inorder(curr.left); 
        if(prev != null && prev.val > curr.val) { 
            if(one == null) {
                one = prev;
            }
            two = curr;
        }
        prev = curr;
        inorder(curr.right);
    }
}