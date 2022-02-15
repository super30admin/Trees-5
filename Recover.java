
//  Definition for a binary tree node.

// Time complexity: O(N) in the worst case when one of the swapped nodes is a rightmost leaf.
// Space complexity : O(N) to keep the stack in the worst case when the tree is completely lean.
public class Recover {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode prev;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        if (prev != null && prev.val >= root.val) {
            if (second == null && first == null) {
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