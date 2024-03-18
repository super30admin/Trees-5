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
//TimeComplexity:O(n)
//SpaceComplexity:O(1)
class Solution {
    public Node connect(Node root) {
        Node level=root;
        Node current = root;
        if(root == null) {
            return root;
        }
        while(level.left != null) {

            while(current != null) {
                current.left.next = current.right;
                if(current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            level = level.left;
            current = level;
        }
return root;
    }
}