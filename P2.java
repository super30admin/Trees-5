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


//inorder traversal,
//breach is when, prev>curr
//if 1st breach, put prev and curr in first and last, keep flag
//if 2nd breach replace last with curr

//time-o(n)
//space-o(h)

class Solution {
    TreeNode first;
    TreeNode last;
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {
      
       first = new TreeNode(Integer.MIN_VALUE);
       last = new TreeNode(Integer.MIN_VALUE);
       prev= new TreeNode(Integer.MIN_VALUE);
     
        
       inorder(root);
       
        //swap
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    
    public void inorder(TreeNode root)
    {
        if(root == null) return;
        
        inorder(root.left);
        
        if(prev.val>root.val)//breach
        {
            if(first.val==Integer.MIN_VALUE)//first breach
            {
                first = prev;
                last = root;
            }
            else//second breach
            {
                last = root;
            }
        }
        prev = root;               
        
        
        inorder(root.right);
    }
}