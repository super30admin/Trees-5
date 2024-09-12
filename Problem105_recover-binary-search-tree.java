// TC: O(n)
// SC: O(h)
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        inorder(root);
        // swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            if(first == null) {
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