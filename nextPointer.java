/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
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
TC --> O(n)
Sc --> O(h)
 */

class Solution {

    public Node connect(Node root) {
        Helper(root, null, 1);
        return root;
    }

    public void Helper(Node root, Node parent, int direction) {
        if (root != null) {
            if (parent != null) {
                if (direction == 1) {
                    root.next = parent.right;
                } else {
                    if (parent.next != null) {
                        root.next = parent.next.left;
                    }
                }
            }

            Helper(root.left, root, 1);
            Helper(root.right, root, -1);

        }
    }
}
