// Time Complexity : O(N)- worst case we need to traverse every node
// Space Complexity : O(1) - As we are doing a iterative approach and no additional data structure is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
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
        if(root == null) return root;
        
        Node curr = root;
        while(curr.left != null){
            Node head = curr;
            while(head != null){
             head.left.next = head.right;
            if(head.next != null){
                head.right.next = head.next.left;
            }
                head = head.next;
            }
            curr = curr.left;
        }
        return root;
    }
}

// Your code here along with comments explaining your approach
