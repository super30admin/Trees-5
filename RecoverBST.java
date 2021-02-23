class RecoverBST {
    /*
      Time : O(N) | we're touching each node once.
      Space : O(h) | height of a tree (recursive stack space)
      Leetcode : YES
    */
    
    TreeNode first; TreeNode last;
    TreeNode prev;
    boolean flag;
    
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = last.val;
        last.val = first.val;
        first.val = temp;
    
    }
    
    private void inorder(TreeNode root){
        // base
        if(root == null) return;
        inorder(root.left);
        
        if(prev != null && prev.val >= root.val){
            if(!flag){
                first = prev;
                last = root;
                flag = true;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
