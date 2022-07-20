//****RECOVER BINARY SEARCH TREE****
//Time complexity: 0(n);
//Space complexity:0(H); recursive stack space;
//Leetcode runnable: Y;
//

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
    public void recoverTree(TreeNode root) {
        //null case
        if(root==null)
        {
            return ;
        }
        
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    
    public void inorder(TreeNode root)
    {
        //Base case
        if(root==null)
        {
            return;
        }
        //Logic
        inorder(root.left);
        //Breach
        if(prev==null || prev.val>=root.val)
        {
            //First breach
            if(first==null)
            {
                first=prev;
                second=root;
                
            }
            else
            {
                second=root;
            }
        }
        prev=root;
        
        
        inorder(root.right);
    }
}
