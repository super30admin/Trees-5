//116. Populating Next Right Pointers in Each Node.java
//Time Complexity:O(n)
//Space Complexity:O(logn) as it is perfect BTREE

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
        if(root == null)
            return null;
        root.next = null;
        helper(root);
        return root;
    }
    
    public void helper(Node root){
        
        if(root == null)
            return;
        Node left = root.left;
        Node right = root.right;
        
        if(left!= null){
            root.left.next = root.right;
        }
        
        if(right!= null){
            if(root.next != null)
              root.right.next = root.next.left;
        }
        helper(root.left);
        helper(root.right);
    }
}
