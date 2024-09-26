
//Time Complexity-O(V+E)
//Space Complexity-O(max depth of tree)
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
    public void recoverTree(TreeNode root) {
        if(root==null)
        {
            return;
        }
        TreeNode prev=null;
        TreeNode x=null;
        TreeNode y=null;
        Stack<TreeNode>stack=new Stack();
        while(!stack.isEmpty()||root!=null)
        {
            while(root!=null)
            {
                stack.push(root);
                root=root.left;
            }
            TreeNode popped=stack.pop();
            if(prev!=null && prev.val>popped.val)
            {
                x=popped;
                if(y==null)
                {
                    y=prev;
                }
                else{
                   break; 
                }                
            }            
            prev=popped;    
            root=popped.right;
        }
        swap(x,y);
    }
    private void swap(TreeNode x,TreeNode y)
    {
        int temp=x.val;
        x.val=y.val;
        y.val=temp;
    }
}