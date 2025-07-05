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
 // Time complexity - O(n)
 // Space complexity - O(1)
 // Solved on leetcode - yes
 // faced any issues - No
 // Inorder recursive traversal
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return result;
        inorder(root);
        return result;
    }

    public void inorder(TreeNode root) {
        if(root==null) return;
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
    }
}
