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
    TreeNode first;
    TreeNode second;
    TreeNode prev;
  
  //TC:O(n) sc O(h)
    public void recoverTree(TreeNode root) {
        if(root==null)return ;
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    private void inorder(TreeNode root){
        //base
        if(root==null)
            return;
        
        inorder(root.left);
        
        if(prev!=null && prev.val>=root.val){//breach
        //first breach
        if(first==null){
        first=prev;
        second=root;
        }
            //second breach
            else{
                second=root;
            }
        }
        prev=root;
        
        inorder(root.right);
        
        
    }
}
