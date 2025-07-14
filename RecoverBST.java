/**
 * Leetcode 99. Recover Binary Search Tree
 * Link: https://leetcode.com/problems/recover-binary-search-tree/description/
 */
public class RecoverBST {
    /**
     * Recurse over the BST in-order and find pair(s) which are not incrementing(or violating the BST). If we find only two pairs
     * that mean the first element in the first pair and the second element in the second pair are out of place - swap them. If we
     * only find one pair that means the first element and second element both in that pair are out of place - swap them.
     *
     * TC: O(n)
     * Auxiliary SC: O(1)
     * Recursive stack SC: O(h) - height of the tree: max n for skewed tree or logn for perfect binary tree
     */
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        helper(root);
        int firstVal = first.val;
        first.val = second.val;
        second.val = firstVal;
    }

    private void helper(TreeNode root) {
        //base
        if (root == null) {
            return;
        }

        //logic
        helper(root.left);

        //in-order level main logic check since BST is sorted here
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;

        helper(root.right);
    }
}
