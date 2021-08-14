// Time Complexity : O(n)
// Space Complexity : O(H), H = Height of the tree, stack space
// Did this code successfully run on Leetcode : Yes
class Solution {
    TreeNode first, last, prev = null;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        inorder(root);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    private void inorder(TreeNode root) {
        //base case
        if(root == null)
            return;
        inorder(root.left);
        if(prev != null && prev.val > root.val) {
            if(!flag) {
                first = prev;
                last = root;
                flag = true;
            }
            else
                last = root;
        }
        prev = root;
        inorder(root.right);
        
    }
}