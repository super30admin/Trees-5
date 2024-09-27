//Time Comlpexity:O(n)
//Space Comlexity:O(h)
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
    TreeNode first,last, prev;
    boolean isFirst;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        inorder(root);
        int temp=first.val;
        first.val=last.val;
        last.val=temp;
    }
    public void inorder(TreeNode root){
        if(root==null) return ;
        inorder(root.left);
        if( prev!=null && prev.val>=root.val){
            if(!isFirst){
            first=prev;
            last=root;
            isFirst= true;
        }else{
            last=root;
        }
        }
        prev=root;
        inorder(root.right);
    }
}