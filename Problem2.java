//Time = O(n), number of nodes
//Space = O(h), height of binary tree

class Solution {
    // Initialize the prev, first, and second nodes as null
    private TreeNode prev, first, second;

    public void recoverTree(TreeNode root) {
        // Reset the prev, first, and second nodes
        prev = null;
        first = null;
        second = null;
        // Traverse the binary search tree in inorder to find the swapped nodes
        inorderTraversal(root);
        // Swap the values of the first and second nodes to recover the binary search tree
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorderTraversal(TreeNode root) {
        // Base case: if the root node is null, return
        if (root == null) {
            return;
        }
        // Traverse the left subtree
        inorderTraversal(root.left);
        // Compare the value of the current node with the value of the previous node
        if (prev != null && prev.val > root.val) {
            // If the current node is the first swapped node encountered, update the first node
            if (first == null) {
                first = prev;
            }
            // Update the second node to be the current node
            second = root;
        }
        // Update the prev node to be the current node
        prev = root;
        // Traverse the right subtree
        inorderTraversal(root.right);
    }
}
