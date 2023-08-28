// TC = O(n)
// SC = O(n)
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
    TreeNode prev;
    TreeNode curr;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        helper(root);
        TreeNode temp = new TreeNode(first.val);
        first.val = second.val;
        second.val = temp.val;
    }
    private void helper(TreeNode root){
        // base
        if(root == null) return;
        // logic
        helper(root.left);
        if(prev!=null && first==null && prev.val>root.val){
            first = prev;
            second = root;
        }else if(prev!=null && first!=null && prev.val>root.val){
            second = root;
        }
        prev = root;
        helper(root.right);
    }
}