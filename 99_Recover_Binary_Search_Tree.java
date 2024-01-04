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

// approach-1
// perofrm ini=order traversal, go through the array, when find the breach,
// assign first and second as prev and next;
// when found second breach, just assign second = first;
// ttc: O(n) - 2 pass
// sc:O(h) + O(n)

/*
 * approach -2
 * take first and second node
 * erform inorder traversal, keep track for prev and root , when find prev >
 * root update first and second
 * tc: O(n)
 * sc:O(h)
 */

class Solution {
    TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        first = null;
        second = null;
        prev = null;

        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return;

    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        // process roots here
        if (prev != null && prev.val >= root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;

        inorder(root.right);
    }
}

// iterative approach
// tc: O(n)
// sc:o(h)

class Solution {
    TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        first = null;
        second = null;
        prev = null;

        Stack<TreeNode> stack = new Stack<>();

        // iterative approach
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            // process breach here
            if (prev != null && prev.val >= root.val) {
                if (first == null) {
                    first = prev;
                }
                second = root;
            }
            prev = root;
            root = root.right;
        }

        // swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return;

    }

}