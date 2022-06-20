/**
Time Complexity : O(N)
Space Complexity : O(D) depth of the tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public Node connect(Node root) 
    {
        if(root == null)
            return root;
        
        dfs(root);
        
        return root;
    }
    
    private void dfs(Node root)
    {
        if(root.left == null) return;
        
        root.left.next = root.right;
        
        if(root.next != null)
            root.right.next = root.next.left;
        
        if(root.left != null)
            dfs(root.left);
        
        if(root.right != null)
            dfs(root.right);
    }
}