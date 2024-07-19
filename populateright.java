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

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node left = root; // initialising left as root
        while (left.left != null) { // checking if there is another level
            Node curr = left; // sett curr to left
            while (curr != null) { // curr exists
                curr.left.next = curr.right; // point left node to relevant right node
                if (curr.next != null) {
                    curr.right.next = curr.next.left; // point right node to relevant right node
                }
                curr = curr.next; // move right
            }
            left = left.left; // move next level
        }
        return root;
    }
}