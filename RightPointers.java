// O(n) time: process each node once
// O(1) space

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
        
        if (root == null) {
            return root;
        }
        
        // Start with the root node
        Node leftmost = root;
        
        // done when we reach final level
        while (leftmost.left != null) {
            
            // Iterate linked list
            Node head = leftmost;
            
            while (head != null) {
                head.left.next = head.right; // first connection
                
                if (head.next != null) { // second connection
                    head.right.next = head.next.left;
                }
                
                // Progress along the list (nodes on the current level)
                head = head.next;
            }
            
            // Move onto the next level
            leftmost = leftmost.left;
        }
        
        return root;
    }
}