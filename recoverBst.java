// Time Complexity : O(n) - where n is the total number of nodes in the tree
// Space Complexity : O(h) - O(logn) - the stack space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Kind of a little off inorder but rest is fine.
// Your code here along with comments explaining your approach ; We try to use the inorder approach and get the nodes in an ascending order. If the order is disturbed once we assign the nodes first and last. If that is the only  disturbance in the ascending order, we have found our nodes. Other wise the second  disturbance is where the second node is found. 


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
    TreeNode first;TreeNode last; TreeNode prev=null;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        inorder(root);
        int temp=first.val;
        first.val=last.val;
        last.val=temp;
    }
    public void inorder(TreeNode root){
        //base
        if(root==null) return;
        //logic
        inorder(root.left);
        //st.pop()
        if(prev!=null && prev.val>=root.val){
           if(!flag){
            first= prev;
            last=root;
            flag=true;
           }  
         else{
                last=root;
        }
        }
        prev=root;
        inorder(root.right);
        
    }
}