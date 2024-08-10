// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    boolean flag;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private void inorder(TreeNode root) {
        // base
        if (root == null)
            return;

        // logic
        inorder(root.left);

        if (prev != null && prev.val > root.val) {
            if (!flag) {
                first = prev;
                second = root;
                flag = true;
            } else
                second = root;
        }
        prev = root;

        inorder(root.right);
    }
}