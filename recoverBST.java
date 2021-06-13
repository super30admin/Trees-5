//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

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
//The logic used is I am taking 2 nodes which keeps a track on the number of breaches. The logic would check for if the tree is BST by using a prev pointer and current root. If the property of BST is breached, that would be the first breach and so on we check if there is a second breach or not.
class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode last;
    boolean flag;
    public void recoverTree(TreeNode root) {
        
     
        
        prev = null;
        helper(root);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
        
    }
    
    private void helper(TreeNode root){
        
        if(root == null){
            
            return;
        }
        
        
        //logic
        helper(root.left);
        
        if(prev != null && root.val <= prev.val){//breach
            
            if(flag == false){//first breach
            //int temp = root.val;
             first = prev;
             last = root;
            flag = true;
                
            }
            else{//second breach
                
                last = root;
                
            }
          
        }
        prev = root;
        //recurse
         helper(root.right);
        }
}