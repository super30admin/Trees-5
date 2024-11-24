class Solution {
    TreeNode prev;
    TreeNode first,second;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp;
        temp=first.val;
        first.val=second.val;
        second.val=temp; 
    }
    
    
    private void helper(TreeNode root){
        
        if(root==null) return;
        
        helper(root.left);
        if(prev!=null && prev.val>=root.val){
           if(first==null){
               first=prev;
               second=root;
           }else{
               second=root;
           }
        }
        prev=root;
        helper(root.right);
    }
}