// Time Complexity :O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
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
    TreeNode first;
    TreeNode second;
    boolean breach = false;
    public void recoverTree(TreeNode root) {
        if(root==null){
            return;
        }
        
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev!=null && prev.val>=root.val){
            //first breach
            if(!breach){
                first = prev;
                second = root;
                breach = true;
            }else{
                //second breach
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}