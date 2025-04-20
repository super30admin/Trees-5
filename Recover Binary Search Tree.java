class Solution {
    // TC: O(n), SC: O(h) where h is height of tree (due to recursion)
    private TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        first = second = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (first == null && prev.val > root.val) {
            first = prev;
        }
        if (first != null && prev.val > root.val) {
            second = root;
        }
        prev = root;

        inorder(root.right);
    }
}
