// TC: O(n)
// SC: O(log n) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] inorder) {
        return buildTreeHelper(inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(inorder[mid]);
        root.left = buildTreeHelper(inorder, left, mid - 1);
        root.right = buildTreeHelper(inorder, mid + 1, right);
        return root;
    }
}
