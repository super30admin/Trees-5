// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
As per this traversal algorithm, we need to find predecessor of each node by going to the current node's left
child(if available) and then traversing to its rightmost child and establishing a connection between this right
child and current node and go through left children if no connection exists.If not(no left node), we simply
 add current node to the list and traverse through right children.If we found predecessor through left and
 rightmost child and if there is an already existing connection, we break that connection and add the
  current node and go to right children.
 */
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
    List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        this.result = new ArrayList<>();
        if(root == null)
            return result;
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode pre = curr.left;
                while(pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                if(pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                }
                else {
                    pre.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}