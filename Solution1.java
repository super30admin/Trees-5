//Time complexity: O(N), where N is the number of nodes in tree.
//Space complexity: O(1)

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


class Solution {
    public Node connect(Node root) {
        if(root == null) return null; 
        
        Node node = root;
        while(node.left != null) {
            Node level = node;
            while(level != null) {
                level.left.next = level.right; 
                if(level.next!=null) {
                    level.right.next = level.next.left;
                }
                level = level.next; 
            }
            node = node.left;
        }
        
        return root;
    }
}