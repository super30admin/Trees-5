// TC: O(n)
// SC: O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    TreeNode first, last, prev;
    boolean flag;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        inorder(root);
        int temp = last.val;
        last.val = first.val;
        first.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && root.val < prev.val) {
            if (!flag) {
                flag = true;
                first = prev;
                last = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
