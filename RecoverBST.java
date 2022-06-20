/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    
    public void recoverTree(TreeNode root) 
    {
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode first = null;
        TreeNode second = null;
        boolean isFirst = true;
        TreeNode prev = null;
        
        while(root != null || !stack.isEmpty())
        {
            
            while(root!=null)
            {
                stack.push(root);
                root = root.left;
            }
            
            TreeNode current = stack.pop(); // this is left most element
            
            if(prev != null)
            {
                if(prev.val > current.val)
                {
                    if(isFirst)
                    {
                        first = prev;
                        second = current;
                        isFirst = false;
                    }
                    else
                    {
                        second = current;
                    }
                }
            }
            
            prev = current;
            
            root = current.right;
        }
        
        
        if(first != null && second != null)
        {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        
    }
}