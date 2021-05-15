// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
  public Node connect(Node root) {
    if (root == null)
      return root;

    Node level = root;

    while (level.left != null) {
      Node cur = level;
      while (cur != null) {
        cur.left.next = cur.right;
        if (cur.next != null) {
          cur.right.next = cur.next.left;
        }
        cur = cur.next;
      }
      level = level.left;
    }
    return root;
  }
}
