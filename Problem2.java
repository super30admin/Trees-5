// Time Complexity : O(n)
// Space Complexity :O(h) - height of the BST
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//We perform inorder traversal and maintain previous and current pointer and compare the previous node value with current node value
//whenever previous node value is greater than current we swap two nodes if no further breaches present
//if second breach occurs we assign another two pointers to keep track and move the second pointer to the current node

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
    TreeNode prev = null;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        inorder(root);
        //swap first and second
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        //base
        if(root == null) return;

        //logic
        inorder(root.left);

        if(prev != null && root.val <= prev.val) {
            //first breach
            if(first == null) {
                first = prev;
                second = root;
            } else {
                //second breach
                second = root;
            }
        }
        prev = root;

        inorder(root.right);
    }
}
