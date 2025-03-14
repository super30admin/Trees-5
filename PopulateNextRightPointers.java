/*
 * TC: O(n)
 * SC: O(1)
 */
public class PopulateNextRightPointers {

    // Definition for a Node.
    public static class Node {
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
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        // start at the root, there are no next pointers
        // to be set
        Node leftmost = root;

        // set up connections for the next level
        while (leftmost.left != null) {
            // start from the leftmost node
            Node head = leftmost;
            while (head != null) {

                // establish connection between children
                // of same parent
                head.left.next = head.right;

                // if there is a next parent, establish connection
                // between right child of current and left child of next
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // move to next node in current level
                head = head.next;
            }
            // move down to next level
            leftmost = leftmost.left;
        }
        return root;
    }
}
