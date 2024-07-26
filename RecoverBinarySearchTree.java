// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
  TreeNode prev;
  TreeNode first;
  TreeNode second;
  int count;
  public void recoverTree(TreeNode root) {
    if(root == null) return;
    inorder(root);
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
  }

  void inorder(TreeNode root) {
    // Base
    if(root == null || count == 2) return;
    // Logic
    inorder(root.left);
    if(prev!=null && prev.val>root.val) {
      count++;
      if(first == null) first = prev;
      second = root;
    }
    prev = root;
    inorder(root.right);
  }
}