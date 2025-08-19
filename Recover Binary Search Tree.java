// Time Complexity : O(n), where n is the number of nodes; we visit each node exactly once via in-order traversal.
// Space Complexity : O(h) for recursion stack (h = tree height; O(log n) balanced, O(n) skewed).
// Did this code successfully run on Leetcode : Yes

Approach :

// An in-order traversal of a valid BST yields a strictly increasing sequence of values.
// If exactly two nodes are swapped, the in-order sequence will contain one or two “inversions” where a previous value is ≥ the current value.
// During traversal, keep pointers prev (last visited), first (first node of the first inversion), and second (current node at the most recent inversion).
// On the first inversion, set first = prev; on every inversion (first or second), set second = current.
// After traversal, swap first.val and second.val to restore BST order.

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
    TreeNode first;
    TreeNode prev;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(prev != null && prev.val >= root.val){
            if(first == null)
                first = prev;
            second = root;
        }
        prev = root;
        helper(root.right);
    }
}
