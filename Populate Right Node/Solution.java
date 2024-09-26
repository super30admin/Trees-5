/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node start = root;
        
        // iterate with start
        while(start != null) {
            Node curr = start;
            // iterate along the level with next pointer
            while(curr != null) {
                
                if(curr.left != null) curr.left.next = curr.right;
                if(curr.right != null && curr.next != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            start = start.left;
        }
        return root;
    }
}