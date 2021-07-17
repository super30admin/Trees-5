// Time: O(n)
//Space: O(edge)

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
    TreeNode prev; TreeNode first; TreeNode second;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void helper(TreeNode root){
        
        if(root == null) return;
        
        helper(root.left);
        if(prev != null && prev.val >= root.val){
            if(!flag){
                first = prev;
                second = root;
                flag = true;
            } else {
                second = root;
                return;
            }
        }
        prev = root;
        helper(root.right);
    }
}