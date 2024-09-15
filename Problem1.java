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
        if(root==null)
            return null;
        Node level = root;
        Node current;
        while(level.left!=null){

            current = level;

            while(current!=null){

                current.left.next = current.right;

                if(current.next!=null)
                    current.right.next = current.next.left;

                current = current.next;
            }

            level = level.left;

        }
        return root;
    }
}