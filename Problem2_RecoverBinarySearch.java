// Time Complexity : o(n)
// Space Complexity : 0(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
   
    TreeNode prev=null,first=null,second=null;
    
    public void recoverTree(TreeNode root) {
        
        inOrder(root);
        
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
       
    }
    
    private void inOrder(TreeNode curr)
    {
        if(curr==null)
            return;
        
        inOrder(curr.left);
        
        if(prev!=null && prev.val>curr.val)
        {
            if(first==null)
                first=prev;
            second=curr;
        }
        prev=curr;
        inOrder(curr.right);
    }
}