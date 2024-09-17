
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

/**
 * Time complexity: O(N) where N is number of nodes in tree.
 * Space complexity: O(1) 
 * 
 * Approach:
 * 1. Traverse levelwise, next level poniting to left node of current element.
 * 2. In each level, assign left node's next pointer of parent node to right node and assign right node's 
 * next pointer to parent node's next node's left node.
 */

class NextPointerTree {
    public Node connect(Node root) {
        
        if(root == null)
            return root;
        
        Node level = root;
        
        while(level.left != null) {
            
            Node curr = level;
            while(curr != null) {
                curr.left.next = curr.right;
                if(curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        
        return root;
        
    }
}