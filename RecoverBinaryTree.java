/* You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
* TC O(N) SC O(N)
*/
class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        if (root == null){
            return;
        }
      
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (prev != null && prev.val > root.val)
        {
            if (first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        helper(root.right);
    }
}
