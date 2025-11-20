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
        first = null;
        second = null;

        if (root == null || (root.left == null && root.right == null)) return;

        findIncorrectNodes(root);

        if (second == null) second = root;
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private void findIncorrectNodes(TreeNode root) {

        if (root == null) return;

        findIncorrectNodes(root.left);

        if (prev != null && prev.val > root.val) {
            // incorrect order detected

            if (first == null) first = prev;
            second = root;
        }

        prev = root;

        findIncorrectNodes(root.right);

    }
}
