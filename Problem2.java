/*
Recover a BST
approach: do inorder, at each node check if it is following BST properties
time: O(n)
space: O(1)
 */
public class Problem2 {
    /*
        TreeNode prev, first, second;
    public void recoverTree(TreeNode root) {
        helper(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }

    private void helper(TreeNode root) {
        if(root==null) return;

        helper(root.left);
        if(prev!=null && root.val<=prev.val) {
            if(first==null) {
                first = prev;
                second = root;
            }
            else {
                second = root;
            }

        }
        prev = root;
        helper(root.right);
    }
     */
}
