// Time Complexity :O(n) n-number of nodes
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes 
// https://leetcode.com/problems/recover-binary-search-tree/
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
    boolean flag;
    TreeNode left;TreeNode right;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        inorder(root); 
        int temp=left.val;
        left.val=right.val;
        right.val=temp;
        return;
    }
    
    public void inorder(TreeNode root)
    {
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && prev.val>=root.val)
        {
            if(!flag)
            {
                left=prev;
                right=root;
                flag=true;
            }else{
                right=root;
            }
        }
        prev=root;
        inorder(root.right);
        
        
    }
}