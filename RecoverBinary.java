package Trees-5;
// Time Complexity : O(n) // n is number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class RecoverBinary {
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
    boolean flag;
    TreeNode first;
    TreeNode last;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        System.out.println("First: "+ first.val+"Last :"+ last.val);
         int x = first.val;
         first.val = last.val;
         last.val = x;
         
    }
    
    private void inorder(TreeNode root)
    {   
        
        if(root == null) return;
        inorder(root.left);
        if(prev!=null && prev.val>=root.val)
        {
            
            if(!flag)
            {
              System.out.println("Prev: "+ prev.val+"Curr :"+ root.val);  
              first = prev;
              last = root;
              flag = true;
            }else{
                
                last = root;
            }
        }
        prev = root;
        inorder(root.right);    
    }
}
    
}
