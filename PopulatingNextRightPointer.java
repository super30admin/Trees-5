// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// In this approach we will create node variable leftmost
// The next of left child would be the right child
// The next of right child would be the left child of next node
// We will carry this idea in a loop hence without traversing level order using queue
// We are able to traverse the nodes in level order using next attribute

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
        Node leftmost = root;
        while(leftmost.left != null){
            Node head = leftmost;
            while(head != null){
                head.left.next = head.right;
                if(head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}