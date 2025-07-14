import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 94. Binary Tree Inorder Traversal
 * Link: https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */
public class BTInorderTraversal {
    /**
     * Morris Inorder Traversal solution where for a given node we find the right most node in its subtree and link that node's
     * right pointer to current not in the first pass. When we reach the same curr node second time we remove that link. TC wise at
     * each curr node we are finding right most node in the subtree which is potentially a O(h) operation. If we think about not a very
     * skewed binary tree then majority of the nodes in entire tree are found at the last few levels. For perfect BT, 75%(50 + 25) nodes
     * are in last 2 levels. So this O(h) becomes Amortized O(1) time.
     *
     * TC: O(n)
     * SC: O(1)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        TreeNode prev;

        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                prev = curr.left;

                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) { //first time visiting given curr, link right most next in the left subtree to curr
                    prev.right = curr;
                    curr = curr.left;
                } else { // second time vising given curr, remove the previously created link
                    prev.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}
