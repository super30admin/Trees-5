// Time Complexity : O(n)
// Space Complexity : O(n)


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
        
        // Empty node
        if (root == null){
            return null;
        }
        
        // Pre-order Traversal NLR
        // Node (N)
        if (root.left != null){ 
            // Connect left and its next
            root.left.next = root.right; 
        }
        
        if (root.right != null && root.next != null){
            
            // Connect right to its next node
            root.right.next = root.next.left;
        }
        
        
        // left sub tree
        connect(root.left);
        
        // right sub tree
        connect(root.right);
        
        
        return root;
    }
}