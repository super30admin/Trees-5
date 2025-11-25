/*
 Binary tree node with next pointer used for the "populating next right pointers" problems.

 Fields:
 - int val: node value
 - Node left: left child
 - Node right: right child
 - Node next: pointer to next right node at same level (or null)

 Notes:
 - Typically used with perfect binary tree algorithms (LeetCode 116).
 - Class itself is a data holder; algorithmic complexity depends on code that manipulates these nodes.

 LeetCode: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/ (116)
*/

public class Node {

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
}
