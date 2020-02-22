//TC - O(n)
//SC - O(h)

class Solution {
    TreeNode f = null;
    TreeNode m = null;
    TreeNode l = null;
    TreeNode prev = null;
    
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        
        helper(root);
        
        if(f != null)
        {
            if(l != null)
            {
                int t = l.val;
                l.val = f.val;
                f.val = t;
            }
            else
            {
                int p = m.val;
                m.val = f.val;
                f.val = p;
            }
        }
    }
    
    
    private void helper(TreeNode node)
    {
        if(node == null) return;
        
        //logic
        helper(node.left);
        
        if(prev != null && node.val < prev.val)
        {
            if(f == null)
            {
                f = prev;
                m = node;
            }
            else   
            {
                l = node;
            }
        }
        prev = node;
        
        helper(node.right);
    }
}
