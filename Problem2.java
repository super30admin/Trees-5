//Time complexity is O(n)
//Space complexity is O(1)

class RecoverBst {
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        // base
        if (root == null)
            return;
        // logic
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            // first breach
            if (first == null) {
                first = prev;
                second = root;
            } else {// 2nd breach
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
