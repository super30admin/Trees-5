class Solution {
    TreeNode first, second, prev;
    
    public void recoverTree(TreeNode root) {    
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void helper(TreeNode root){
        if(root!=null){
            helper(root.left);
            
            if(prev!=null && (root.val<prev.val)){
                if(first==null){
                    first = prev;
                    second = root;
                }
                else{
                    second = root;
                }
            }
            
            prev = root;
            helper(root.right);
        }
    }
}