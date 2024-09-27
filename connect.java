// approch 1
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

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

class Main {

    // approch 1 using BFS traversal
    public Node connect1(Node root) {
        if (root == null)
            return root;
        Queue<Node> q = new LinkedList<>();
        // add root into the queue
        q.add(root);
        // while q is not empty traverse in the tree
        while (!q.isEmpty()) {
            // maintain a size for level
            int size = q.size();
            // traverse at each node in particular level
            Node prev = null;
            for (int i = 0; i < size; i++) {
                // get first element from the queue
                Node cur = q.poll();
                if (prev != null) {
                    prev.next = cur;
                }
                // update previous node
                prev = cur;
                // add left node and right node into the Queue
                if (cur.left != null) {
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
        }
        return root;

    }

    // approch 2 using BFS traversal without using Queue(Extrs space)
    public Node connect2(Node root) {
        // null case
        if (root == null)
            return root;
        // to traverse at each level
        // intially level is at root node
        Node level = root;
        // traverse throuch each level until level.left is not null as we know this is
        // the leaf node
        while (level.left != null) {
            // get current element from the left most element at each level
            // that means level itself
            Node cur = level;
            // make a connection between desired node
            // here we traverse from left to right at each level
            while (cur != null) {
                // at each level we make a connection between children node
                cur.left.next = cur.right;
                // here we check if cur.next is not null then we can make a connection
                // b/w current.right and left of next node at each level
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                // here we go next current node
                cur = cur.next;
            }
            // increase the level
            level = level.left;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}