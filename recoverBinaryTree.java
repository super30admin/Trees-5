//time O(n)
//space O(1)

class Solution {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            if(first == null) {
                first = root;
                second = prev;
            } else {
            first = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
