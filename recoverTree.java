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

 //Time : O(n) n is the nodes of the tree;
 //Space : O(h) h is the height of the recurive stack
 //Leetcode : worked

class Solution {
    TreeNode first; TreeNode last;
    TreeNode prev; boolean flag =false;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = last.val;
        last.val = first.val;
        first.val = temp;
    }
    
    public void inorder(TreeNode root){
        //base
        if(root == null) return;
        
        //logic
        inorder(root.left);
        if(prev!=null && prev.val>=root.val){
            if(!flag){
                flag = true;
                first = prev;
                last = root;
            }else{
                last = root;
            }
        }
        
        prev = root;
        inorder(root.right);
    }
}