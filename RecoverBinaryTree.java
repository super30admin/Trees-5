// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        inorder(root);
        // swapping faulty nodes
        int temp = second.val;
        second.val = first.val;
        first.val = temp;

    }

    public void inorder(TreeNode root) {
        // edge case
        if (root == null)
            return;
        // logic
        inorder(root.left);
        // checking for breaches
        if (prev != null && prev.val >= root.val) {
            // if first breach already took place, we just need to set second breach only
            if (first != null && second != null) {
                second = root;
            } else {
                first = prev;
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}