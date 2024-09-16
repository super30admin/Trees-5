// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach

// Time Complexity : O(n) touching all nodes at once
// Space Complexity :O(logn) maximum element in therecursive stack

class Solution {
 //Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
    //Recursive 
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if (root==null) return;
        helper(root);
        int temp= first.val;
        first.val=second.val;
        second.val=temp;
        
        return;
    }
    
    private void helper(TreeNode root){
        
        //base
        if(root==null)
            return;
        
        //logic
        helper(root.left);
        if(prev!=null && prev.val>=root.val){
            if(first==null){
                first=prev;
                second=root;
            }
            else{
                second=root;
            }
        }
        prev=root;
        helper(root.right);
    }
}