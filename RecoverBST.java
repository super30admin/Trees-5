/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


**/
class Solution 
{
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    boolean isFirst;
    
    public void recoverTree(TreeNode root) 
    {
        this.isFirst = true;
        
        inorder(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root)
    {
        if(root == null)
            return;
        
        if(root.left != null)
            inorder(root.left);
        
        if(prev != null && prev.val > root.val)
        {
            if(isFirst)
            {
                first = prev;
                second = root;
                isFirst = false;
            }
            else
            {
                second = root;
            }
        }
        
        prev = root;
        
        if(root.right != null)
            inorder(root.right);
    }
}