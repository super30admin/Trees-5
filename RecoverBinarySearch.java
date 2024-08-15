// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
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
class RecoverBinarySearch {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    boolean flag;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        // base
        if (root == null)
            return;

        // recursion on left
        inorder(root.left);
        // process root
        if (prev != null && prev.val >= root.val) {
            if (first == null) {
                // first breach;
                first = prev;
                second = root;
            } else {
                // second breach
                second = root;
                flag = true;
            }
        }
        prev = root;
        // recursion on right
        if (!flag)
            inorder(root.right);
    }
}