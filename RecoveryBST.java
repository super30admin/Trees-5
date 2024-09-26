// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
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
    TreeNode prev, first, second;
    public void recoverTree(TreeNode root) {
        if (root == null) return;

        inOrder(root);
        int temp = second.val;
        second.val = first.val;
        first.val = temp;

    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);
        //set previous
        if (prev != null && prev.val > node.val) {
            if (first == null) first = prev;
            second = node;
        }
        prev = node;
        inOrder(node.right);
    }
}
