class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// O(n) time, O(h) space
class Solution {

    TreeNode prev;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {
        helper(root);

        // swap
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
    }

    // doing inorder traversal
    private void helper(TreeNode root) {
        if (root == null) return;

        helper(root.left);

        if (prev != null && prev.val >= root.val) {
            if (first == null) { // 1st breach

                first = prev;
                second = root;
            }
            else { // 2nd breach
                second = root;
            }
        }

        prev = root;

        helper(root.right);
    }
}
