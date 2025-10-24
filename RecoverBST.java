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
 * The idea is to do inorder traversal and constantly look for the misplaced value
 * Using prev pointer, find the first and second misplaced val
 * Once both the misplaced nodes are found, swap those nodes
 TC: O(n) -> iterate through all the nodes in worst case
 SC: O(h) -> recursive stack space height of the tree
  */
class Solution {
    TreeNode first, second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        helper(root);
        //swap the misplaced nodes val
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root){
        //base
        if(root == null)
            return;
        //logic
        helper(root.left);

        // if we have not reached the null node and the val of prev is greater than root.val, then we have found the first misplaced node
        if(prev != null && prev.val >= root.val){
            //check first breach
            if(first == null){
                first = prev;
                second = root;
            }
            //found second breah
            else
                second = root;
        }
        
        prev = root;

        helper(root.right);

    }
}