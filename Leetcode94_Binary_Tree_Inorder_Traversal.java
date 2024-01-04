/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// tc: O(n)
// sc:O(h)
class Solution {
    List<Integer> path;

    public List<Integer> inorderTraversal(TreeNode root) {

        path = new ArrayList<>();

        if (root == null)
            return path;

        inorder(root);

        return path;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        path.add(root.val);
        inorder(root.right);
    }
}