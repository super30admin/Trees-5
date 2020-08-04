Executed in leetcode-Yes
Time && Space Complexity-o(n)
        
    class Solution {
        TreeNode prev=null;
        TreeNode first= null; TreeNode last =null;

    public void recoverTree(TreeNode root) {
        
         inorder(root);
        int tmp = first.val;
        first.val=last.val;
        last.val=tmp;
    }
    
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && prev.val>=root.val && first==null) {first=prev;last=root;}
        else if(prev!=null && prev.val>=root.val && first!=null) last=root;
        prev=root;
        inorder(root.right);
    }
}
