//Time: O(N)
//Space: O(H)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null; // Initialize prev as null

    public void recoverTree(TreeNode root) {
        inorder(root);
        // Swap the values of the first and second nodes to correct the BST
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        // Inorder traversal of the left subtree
        inorder(root.left);

        // Detect violation: prev should be smaller than the current node
        if (prev != null && prev.val >= root.val) {
            if (first == null) {
                first = prev;  // The first violation found
            }
            second = root;  // The second violation (this keeps updating until the last violation)
        }
        
        // Update prev to current node
        prev = root;

        // Inorder traversal of the right subtree
        inorder(root.right);
    }
}
