// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

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

    TreeNode first;
    TreeNode last;
    TreeNode prev;
    boolean flag;

    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        inorder(root);
        int temp = last.val;
        last.val = first.val;
        first.val = temp;
    }

    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        if(prev != null && root.val < prev.val){
            if(!flag){
                flag = true;
                first = prev;
                last = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}