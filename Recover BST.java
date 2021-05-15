// Time Complexity :O(h)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
  TreeNode first, second, prev;

  public void recoverTree(TreeNode root) {
    if (root == null)
      return;

    inorder(root);
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
  }

  private void inorder(TreeNode root) {
    if (root == null)
      return;

    inorder(root.left);
    if (prev != null && prev.val > root.val) {
      if (first == null)
        first = prev;
      second = root;
    }
    prev = root;

    inorder(root.right);
  }
}