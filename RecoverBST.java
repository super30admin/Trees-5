// Time Complexity : O(n), n -> Number of nodes in the tree
// Space Complexity : O(n)
class Solution {
    boolean flag;
    TreeNode prev, first, last;

    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);

        // swap
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }

    private void inorder(TreeNode root) {
        //base
        if(root == null) return;

        //logic
        inorder(root.left);

        if(prev != null && prev.val > root.val) {

            if(!flag) {
                flag = true;
                first = prev;
                last = root;
            }

            else {
                last = root;
            }
        }

        prev = root;
        inorder(root.right);
    }
}