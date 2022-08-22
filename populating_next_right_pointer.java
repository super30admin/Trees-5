// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        // BFS without Queue solution

        Node lvl = root;
        Node curr = null;
        while (lvl.left != null) {
            curr = lvl;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            lvl = lvl.left;
        }
        return root;

    }
}