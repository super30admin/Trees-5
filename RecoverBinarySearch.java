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
//Time Complexity: O(n)
//Space Complexity: O(h)
class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root)
    {
        helper(root);

        //Swap First and Second
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root)
    {
        //Base case
        if(root == null) return;

        helper(root.left);
        if(prev != null && prev.val >= root.val)
        {
            if(second == null)
            {
                first = prev;
            }
            second = root;
        }
        prev = root;
        helper(root.right);
    }
}