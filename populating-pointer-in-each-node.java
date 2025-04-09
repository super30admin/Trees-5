// TC: O(n)
// SC: O(1) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public Node connect(Node root) {
        Node level = root;
        while (level != null) {
            Node cur = level;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            level = level.left;
        }
        return root;
    }
}
