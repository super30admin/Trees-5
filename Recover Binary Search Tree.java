/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    TreeNode first,last,prev;

    public void recoverTree(TreeNode root) {

        helper(root);

        int x = first.val;
        first.val = last.val;
        last.val = x;
    }

    private void helper(TreeNode root)
    {
        if(root==null) return;

        helper(root.left);

        if(prev!=null)
        {
            if(prev.val > root.val)
            {
                if(first==null) first = prev;
                last = root;
            }
        }

        prev = root;

        helper(root.right);
    }
}
