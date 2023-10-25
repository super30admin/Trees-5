Class Solution {
    TreeNode prev, first, second;
    public void recoverTree(TreeNode root) {
        if(root==null){
            return;
        }
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    private void inorder(TreeNode root){
        //base
        if(root == null){
            return;
        }
        //logic
        inorder(root.left);
        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}