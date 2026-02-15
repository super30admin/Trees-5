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
 // Solution - DFS with two pointers
 // TC - O(n)
// SC - O(1)
class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root) {
        // base
        if(root == null) return;

        // Logic
        helper(root.left);
        if(prev != null && root.val <= prev.val) {
            if(first == null) {
                first = prev;
                second = root;
            }
            else {
                second = root;
            }
        }
        prev = root;
        helper(root.right);
    }
}
