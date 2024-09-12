//Time Complexity : O(n)
//Space Complexity : height of the tree

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
class Solution
{
    public void recoverTree(TreeNode root)
    {
        Stack <TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode x = null;
        TreeNode y = null;
        
        if(root == null) return;
        
        while(!stack.isEmpty() || root != null)
        {
        while(root != null)
        {
            stack.push(root);
            root = root.left;
        } 
            TreeNode top = stack.pop();
            
            if(prev != null && prev.val > top.val)
            {
                y = top;
                if(x != null)
                    break;
                x = prev;
                
            }
            prev = top;
            root = top.right;
        }
            swap(x,y);
        
    }
    
    private void swap(TreeNode x, TreeNode y)
    {
        int temp = x.val;        
        x.val = y.val;
        y.val = temp;
        
    }
}