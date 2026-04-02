// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to traverse level by level where we try to have connections of left child to right child from a
node at a level above one.If next pointer's node is available, we have connection between current's right child
to next node's left child and move the current pointer to next to do the same and traverse downwards through
left child first.
 */
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
            return root;
        Node level = root;

        while(level.left != null) {
            Node curr = level;
            while(curr != null) {
                curr.left.next = curr.right;
                if(curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}