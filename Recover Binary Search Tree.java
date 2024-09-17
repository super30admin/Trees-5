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

// Time Complexity = O(n)
// Space Complexity = O(h)

class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {        
        inorder(root);
        swap(first, second);
    }
    
    private void inorder(TreeNode root){
        // base case
        if(root == null)
            return;
        
        inorder(root.left);
        
        if(prev != null && prev.val > root.val){
            if(first == null){
                first = root;
                second = prev;
            }
            else{
                first = root;
            }
        }
        prev = root;
        
        inorder(root.right);
        
    }
    
    private void swap(TreeNode first, TreeNode second){
        TreeNode temp = new TreeNode();
        temp.val = second.val;
        second.val = first.val;
        first.val = temp.val;
    }
}