/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = null;
 *         this.right = null;
 *     }
 * }
 */
/// Time Complexity : O(N)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// HERE WE do in order traversal but dont use extra list
// check where the breach is 1st and 2nd using pointers prev first and second
// swap it

public class Solution {

    TreeNode prev, first, second;

    public void recoverTree(TreeNode root) {

        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && prev.val >= root.val) {

            if (first == null) {
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