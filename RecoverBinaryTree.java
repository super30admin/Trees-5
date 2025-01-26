lass Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    boolean flag;

    public void recoverTree(TreeNode root) {

        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);

        if (prev != null && prev.val >= root.val) {
            if (first == null) {
                this.first = prev;
                this.second = root;
                
            } else {
                this.second = root;
                flag = true;
            }

        }
        prev = root;
        if(!flag){
            inorder(root.right);
        }
        
    }
}