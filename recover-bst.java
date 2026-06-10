// Time Complexity : O(n) because we perform one inorder traversal of the tree
// Space Complexity : O(h) for the recursion stack where h is the tree height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Inorder traversal of a BST should produce values in sorted order.
// Whenever we find a violation of the sorted order, we identify the misplaced nodes.
// After traversal, swapping the values of the two misplaced nodes restores the BST.

class Solution {
    TreeNode prev;
    TreeNode first, second;

    public void recoverTree(TreeNode root) {
        helper(root);

        // restore BST by swapping misplaced nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root) {
        if(root == null) return;

        helper(root.left);

        // detect inorder violation
        if(prev != null && prev.val >= root.val) {
            if(first == null) {
                first = prev;
            }
            second = root;
        }

        prev = root;

        helper(root.right);
    }
}