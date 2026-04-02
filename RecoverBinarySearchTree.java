// Time Complexity : O(n)
// Space Complexity : O(h), height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Have a helper function to identify the first and second nodes where the discrepancies are present. Do an
inorder traversal and at any time, if previous node is not null and its value remains greater than current
node's value, we found our first and second nodes. If we already found first, we just update second node.We
also update previous node in every recursion.Finally, after we find our nodes, we swap those values.
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
    TreeNode first, second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        helper(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode node) {
        if(node == null)
            return;

        helper(node.left);

        if(prev != null && prev.val >= node.val) {
            if(first == null) {
                first = prev;
                second = node;
            }
            else {
                second = node;
            }
        }

        prev = node;
        helper(node.right);
    }
}