import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    List<Integer> res;

    public List<Integer> inorderTraversal(TreeNode root) {
        this.res = new ArrayList<>();
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;

        helper(root.left);

        res.add(root.val);

        helper(root.right);
    }
}

//TC: o(n), SC: O(h)

//Approach - 2 : Morris Inorder Traversal
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
class MorrisInorderSolution {
    List<Integer> res;

    public List<Integer> inorderTraversal(TreeNode root) {
        this.res = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = root;
                    root = root.left;
                } else {
                    pre.right = null;
                    res.add(root.val);
                    root = root.right;
                }
            }
        }
        return res;
    }
}

//Morris Inorder Traversal - TC: o(n) -amortized, SC: O(1)