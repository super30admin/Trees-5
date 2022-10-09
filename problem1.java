//Problem1 - https://leetcode.com/problems/recover-binary-search-tree/

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

class problem1 {
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }
        prev = root;

        inorder(root.right);
    }
}