class Solution {

    //O(1) space and O(n) time
    TreeNode prev;
    TreeNode first;
    TreeNode last;
    boolean flag;

    public void recoverTree(TreeNode root) {

        inorder(root);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;

    }

    private void inorder(TreeNode root) {

        if (root == null) return;

        inorder(root.left);

        if (prev != null && prev.val >= root.val) {
            if (!flag) {
                first = prev;
                last = root;
                flag = true;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);

    }
}