package Dec7;

import java.util.LinkedList;
import java.util.Queue;

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
*/

class PopulateNextRightPointersBFS {
    
    /*
    Time Complexity: O(n)  because we are traversing through all tree node exactly once.
    Space Complexity: O(n) because we are using auxiliary data structure (queue in this case) because at max, queue will hold n/2 elements, so O(n/2) ~= O(n).
    
    Approach: BFS used.

    */
    public Node connect(Node root) {
        // edge
        if (root == null) {
            return null;
        }
        
        // BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Node cur = queue.poll();
                if (i != qSize - 1) {
                    cur.next = queue.peek();
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }   
        }
        
        return root;
    }
}