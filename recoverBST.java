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
//TC : O(N)
//SC : O(H)
class Solution {
    TreeNode first,second,prev;
    public void recoverTree(TreeNode root) {
        if(root==null) return;

        helper(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root)
    {
        //base
        if(root == null) return;

        //logic
        helper(root.left);
        if(prev!=null && root.val<=prev.val)
        {
            if(first==null)
            {
                first = prev;
            }
            second = root;

        }
        prev = root;
        helper(root.right);

    }
}