// Time complexity: O(n) where n is the number of nodes in the tree
// Space complexity: O(h) Space where n is the number of nodes in the tree and h is the height of the tree

// Intuition: The algorithm uses an inorder traversal to find the two nodes that are out of order in a Binary Search Tree (BST)
// We use the prev pointer to keep track of the previously visited node
// When we find a node that is less than the previous node, we identify the first and last nodes that need to be swapped

public class RecoverBST {
    TreeNode first;
    TreeNode last;

    TreeNode prev;
    boolean flag;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        inorder(root);
        int temp = last.val;
        last.val = first.val;
        first.val = temp;
    }

    private void inorder(TreeNode root) {

        if (root == null)
            return;
        inorder(root.left);
        // root = st.pop();

        if (prev != null && root.val < prev.val) {
            if (!flag) {
                flag = true;
                first = prev;
                last = root;
            } else {
                last = root;
            }
        }

        prev = root;
        inorder(root.right);
    }
}
