// Time complexity : O(n)
// Space complexity w/o recursive stack: O(1)
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
        // edge case
        if(root == null)
            return null;        
        root.next = null;
        assign(root); 
        return root;
    }
    
    public void assign(Node root){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        Node left = root.left;
        Node right = root.right;
        
        left.next = right;
        if(root.next != null){            
            right.next = root.next.left;
        }
        else{
            right.next = null;
        }
        assign(left);
        assign(right);
        
    }
    
}
