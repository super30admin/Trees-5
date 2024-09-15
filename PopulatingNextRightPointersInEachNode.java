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

class PopulatingNextRightPointersInEachNode {
    
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(1)
    
    public Node connect(Node root) {
        // Edge Case Checking
        if(root == null)
            return root;
        Node level = root;
        
        // Go level by level -
        while(level != null){
            Node curr = level;
            
            // Leaf node condition
            if(curr.left == null && curr.right == null)
                break;
            
            while(curr != null){
                // If there's a left node then point the left node to the right node
                if(curr.left != null)
                    curr.left.next = curr.right;

                // Assign the next node of right - to point to the appropriate right node
                if(curr.next != null && curr.right != null)
                    curr.right.next = curr.next.left;
                
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}