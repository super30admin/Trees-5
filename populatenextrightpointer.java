/*
Time Complexity: O(N)
Space Complexity: O(N)
*/

class Solution {
    // main function
    public Node connect(Node root) {
        if (root == null) return null;
        // connect the neighbors
        traverse(root.left, root.right);
        return root;
    }

    void traverse(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        
        // connect the two input nodes
        node1.next = node2;
        
        // connect the nodes with same father 
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        traverse(node1.right, node2.left);
    }
}