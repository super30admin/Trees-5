/*
 Algorithm: Morris Inorder Traversal (threaded binary tree)

 Approach:
 - For each current node:
   - If current.left is null: visit current and move to current.right.
   - If current.left is not null: find predecessor (rightmost node in left subtree).
     - If predecessor.right is null: make predecessor.right = current (create a temporary thread) and move current = current.left.
     - If predecessor.right == current: remove the thread (predecessor.right = null), visit current, and move current = current.right.
 - This produces an inorder traversal without using a stack or recursion.

 Time Complexity: O(n) where n is the number of nodes (each edge is visited constant times).
 Space Complexity: O(1) extra space (excluding the output list) — Morris traversal uses constant extra space.

 LeetCode: https://leetcode.com/problems/binary-tree-inorder-traversal/ (94)
*/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    result.add(current.val);
                    current = current.right;
                }

            } else {
                result.add(current.val);
                current = current.right;
            }
        }
        return result;

    }
}
