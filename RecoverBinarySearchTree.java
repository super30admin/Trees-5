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
// Time Complexity : O(n)
// Space Complexity : O(h), where h is the height of the BST
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        if(null != prev && prev.val >= root.val) {
            if(first == null && second == null) {
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}