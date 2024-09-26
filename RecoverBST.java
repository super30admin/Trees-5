public class RecoverBST {

    /*
    TC : O(N)
    SC: O(n)
     */

    /**
     * Find swap elements of the go using inorder traversal and store them to swap later
     */
    TreeNode prev = null, first = null, second = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null)
                first = prev;
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}
