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
//  TC: O(n)
// SC: O(h)
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    boolean flag;
    public void recoverTree(TreeNode root) {
        this.flag=false;
        inorder(root);
        int temp = second.val;
        second.val=first.val;
        first.val=temp;
    }

    private void inorder(TreeNode root){
        if(root==null) return;

        inorder(root.left);
        if(prev!=null && root.val<prev.val){
            if(!flag){
                flag=true;
                first=prev;
                second=root;
                
            }else{
                second=root;
            }
        }
        prev=root;
        inorder(root.right);
    }
}