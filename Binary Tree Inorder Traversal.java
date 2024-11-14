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


//tc- O(n) sc-O(h)
class Solution {
    List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();

        helper(root);
        return result;

      
    }
    
    private void helper(TreeNode root){
        //base

        if(root == null) return;

        //logic

        helper(root.left);

        this.result.add(root.val);

        helper(root.right);
    }
}