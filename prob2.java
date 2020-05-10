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
//TC:O(n)
//SC:O(maxdepth)
class Solution {
    public void recoverTree(TreeNode root) 
    {
        
        Stack<TreeNode> stk = new Stack<>();
        TreeNode prev = null;
        TreeNode left = null;
        TreeNode middle=null;
        TreeNode right = null;
        while(root!=null ||!(stk.isEmpty()) )
        {
            while(root!=null)
            {
               stk.push(root); 
               root=root.left; 
            }
            
            TreeNode p =null;
             if(!stk.isEmpty())
              p = stk.pop();
            
            if(prev!=null && prev.val>p.val)
            {
             if(left==null)
             {
               left = prev;
               middle=p;
             }
             else
              right=p;
                
            }
              prev=p; 
              root=p.right;
  
        }
        
        if(right!=null) 
        {
          int temp = left.val;
          left.val=right.val;
          right.val =temp;  
        }
        
        else
        {
            int temp = left.val; 
            left.val = middle.val;
            middle.val = temp;
        }
        
    }
    
    
    
    
    
    
    
}