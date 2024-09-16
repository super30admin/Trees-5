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
//time - O(n)
//space - O(h)
class Solution {
    TreeNode first; TreeNode second ;
    boolean flag = true; TreeNode prev;
    public void recoverTree(TreeNode root) {
      inorder(root);
      if(!flag){
          int temp = first.val;
          first.val = second.val;
          second.val = temp;
      }  
    }
    
    public void inorder(TreeNode root){
        
        if(root == null) return;
        inorder(root.left);
        if(prev!=null && prev.val >= root.val){
        if(flag){
            first = prev;
            second = root;
            flag = false;
        }else{
            second = root;
        }
        }
        prev = root;
        inorder(root.right);
    }
}