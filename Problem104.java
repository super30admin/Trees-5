//Time: O(N)
//Space: O(1)
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
            return null;
        }

        // Start with the leftmost node of the tree, which is the root
        Node leftmost = root;

        // Traverse the tree level by level
        while (leftmost.left != null) {
            // Iterate over all nodes at the current level
            Node head = leftmost;
            while (head != null) {
                // Connect the left child to the right child
                head.left.next = head.right;
                
                // Connect the right child to the next node's left child
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                
                // Move to the next node in the current level
                head = head.next;
            }

            // Move to the next level
            leftmost = leftmost.left;
        }

        return root;
    }
}
