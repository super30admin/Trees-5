class Solution {
    TreeNode prev, first, sec;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root);
        int temp = first.val;
        first.val = sec.val;
        sec.val = temp;
    }
    private void inorder(TreeNode root) {
        if(root != null) {
            inorder(root.left);
            if(prev != null && root.val <= prev.val) {
                if(!flag) {
                    first = prev;
                    sec = root;
                    flag = true;
                } else {
                    sec = root;
                    return;
                }
            }
            prev = root;
            inorder(root.right);
        }
    }
}