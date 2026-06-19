// Time Complexity : O(n)
// Space Complexity : O(h)

class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        helper(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void helper(TreeNode root) {
        //base
        if(root == null) return;

        //logic
        helper(root.left);

        if(prev != null && prev.val > root.val) {
            if(first == null) {
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