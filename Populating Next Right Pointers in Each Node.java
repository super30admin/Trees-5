// Time Complexity : O(n), where n is the number of nodes, since each node is enqueued and dequeued exactly once.
// Space Complexity : O(w) for the queue, where w is the maximum width of the tree (O(n) in the worst case).
// Did this code successfully run on Leetcode : Yes

Approach:

// Use level-order traversal (BFS) with a queue to process the tree one level at a time.
// For each level, record the current size so we know how many nodes belong to that level.
// Pop nodes from the queue, enqueue their non-null children, and connect each node’s next pointer to the queue’s front node (q.peek()) if it isn’t the last node in the level.
// If it is the last node of the level, set its next to null.
// Repeat this for all levels until the queue is empty and return the root.

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

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                Node temp = q.poll();
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
                if (i == size - 1)
                    temp.next = null;
                else
                    temp.next = q.peek();
            }
        }
        return root;
    }
}
