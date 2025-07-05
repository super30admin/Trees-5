// TC : O(n)
// SC : O(1)

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
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        helper(root);
        int swapVal = first.val;
        first.val = second.val;
        second.val = swapVal;
    }

    private void helper(TreeNode curr) {
        // Base Case
        if (curr == null){
            return;
        }

        // in-order
        helper(curr.left);

        // prev should always be smaller than curr, BST in-order
        if (prev != null && curr.val < prev.val) {
            if (first == null) {
                first = prev;
                second = curr;
            }
            second = curr;
        }
        prev = curr;

        helper(curr.right);
    }
}