// Time complexity - O(n)
// space complexity - O(1)
// solved on leetcode - yes
// faced any issues - No
// Doing inorder traversal and whereever the breech happens we are updating first and second and finally swapping them
class Solution {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        helper(root);
        
        // Swap the values of the two nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev != null && prev.val >= root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        helper(root.right);

    }
}
