// Time Complexity : O(n) n = no. of nodes
// Space Complexity : constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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

//BFS solution without queue

class Solution {
    public Node connect(Node root) {

        if(root == null)
            return null;

        Node level = root; //iterates down the tree
        Node current = root; //iterates over a particular level

        while(level.left != null)
        {
            current = level;
            while(current != null)
            {
                current.left.next = current.right;
                if(current.next != null)
                    current.right.next = current.next.left;
                current = current.next;
            }
            level = level.left;
        }

        return root;
    }
}
