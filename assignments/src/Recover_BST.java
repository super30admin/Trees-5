// Approach: Do inorder traversal to find the 2 misplaced values. If breach is found in the same subtree,
// swap them, else if in different subtrees, reset the first val to root.val and swap.
// Time: O(n) as we do inorder traversal
// Space: O(n) - O(h) average case where h is height of tree
class Recover_BST {
    TreeNode first, second, prev;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        // st.pop()
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                // first breach
                first = root;
                second = prev;
            }
            else {
                // second breach: breach in 2 different subtrees
                first = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}