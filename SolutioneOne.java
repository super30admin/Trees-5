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
// Time Complexity :O(h) height of the tree
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes

class Solution {

    TreeNode first,prev,last;

    public void recoverTree(TreeNode root)
    {
        if(root==null)
            return;

        inorder(root);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;

    }
    private void inorder(TreeNode root)
    {
        if(root==null)
            return;

        inorder(root.left);

        if(prev!=null && prev.val>=root.val)
        {
            if(first==null)
            {
                first = prev;
                last = root;
            }
            else
            {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}