// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        inorder(root);
        return root;
    }

    private void inorder(Node root) {
        if (root.left == null)
            return;
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        inorder(root.left);
        inorder(root.right);

    }
}