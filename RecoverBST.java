public class RecoverBST {
    TreeNode first, second, prev;
    // TC: O(N) where N is number of nodes in tree
    // SC: O(H) where H is height of tree
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev != null && prev.val >= root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        helper(root.right);
    }
}
