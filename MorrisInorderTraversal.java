// Time Complexity : O(n), all nodes visited
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Traverse the tree using Morris Inorder Traversal.
//   - If left subtree is null, visit the current node and go to the right.
//   - If left subtree exists, find the rightmost node of the left subtree.
//     - If its right child is null, create a temporary thread to the current node and go to the left.
//     - If its right child points to the current node, remove the thread, visit the current node, and go right.


import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MorrisInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                // Find the rightmost node in the left subtree, or the node that already points to curr
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    // Establish a temporary thread back to the current node
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    // The thread already exists, which means we've returned to curr after visiting left subtree
                    pre.right = null; // Restore the tree
                    res.add(curr.val); // Add the current node to result
                    curr = curr.right; // Move to the right subtree
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MorrisInorderTraversal obj = new MorrisInorderTraversal();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = obj.inorderTraversal(root);
        System.out.println("Inorder Traversal using Morris Traversal: " + result);
    }
}
