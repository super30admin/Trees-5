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
 //TimeComplexity:O(n)
 //SpaceComplexity:O(1)
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }
        inorderTraversal(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void inorderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        inorderTraversal(root.left);
        if(prev != null && prev.val > root.val) {
        if(first == null) {
          first = prev;
          second = root;
        } else {
second = root;
        }
        }
        prev = root;
        
        inorderTraversal(root.right);
    }
}