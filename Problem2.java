// 99. Recover Binary Search Tree
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

 /*
Do inorder traversal, so the values should be in ascending order, compare previous and current value if current value is smaller than previous value a breach is detected and set the first and second values, if again a second breach is detected set the second value again
Ran on leetcode: Yes
TC: O(n) SC: O(1)
 */
class Solution {

    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        helper(root);
        // Swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void helper(TreeNode root){
        if(root == null) return;

        // Inorder traversal
        helper(root.left);

        if(prev != null && prev.val > root.val){ // Check if the values are breaching ascending order
            if(first == null){ // adjacent nodes both will be set, first and second to valid values
                first = prev;
                second = root;
            } else { // For non adjacent nodes, second will be set to valid values
                second = root;
            }
        }

        // Previous node of the inorder
        prev = root;

        helper(root.right);
    }
}