import java.util.Stack;

public class RecoverBinarySearchTree {
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
    TreeNode prev, first, second;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        helper(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;

        helper(root.left);

        if (prev != null && prev.val >= root.val) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }

        prev = root;

        helper(root.right);
    }
}

//TC: O(n), SC: O(h)


//Approach - 2 : Iterative
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
class SolutionBST {
    TreeNode prev, first, second;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> st = new Stack<>();

        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();

            if (prev != null && prev.val >= root.val) {
                if (first == null) {
                    first = prev;
                    second = root;
                } else {
                    second = root;
                }
            }

            prev = root;

            root = root.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}

//TC: O(n), SC: O(h)