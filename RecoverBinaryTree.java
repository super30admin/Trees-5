// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Inorder traversal is in ascending order for BST.
//Keep track of prev node.
// Wherever the order breaks, note the node.
// Order can break twice or once based on which nodes are swapped.

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

    boolean bFound = false;
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {

        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private void inorder(TreeNode root) {
         //base
        if(root == null) return;

        //logic
        inorder(root.left);
        if(prev != null && prev.val > root.val) {
            if(!bFound) {
                first = prev;
                second = root;
                bFound = true;
            } else {
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
