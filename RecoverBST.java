//Time O(n)  Space O(h)
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
    TreeNode prev;  // to track prev value -global
    TreeNode first; // first node with issue
    TreeNode second; // second node with issue
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val= second.val;
        second.val=temp;
    }
   private void inorder(TreeNode root) //helper   // L c R
   {  if(root==null)
       return ;
       inorder(root.left);  // Left recursion    1< 2< 3 >2 
       if(prev!=null && prev.val>=root.val)  //if this is true we have a problem
       { if(first==null)   // if this is the first comparison
       {
           first =prev;
           second=root;
       }
        else  // this is the 2nd time we found an issue
        {second = root;}
           
       }
    prev =root;
       inorder(root.right);  //Right recursion
   }
}