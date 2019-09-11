// idea: 
// This is a level order traversal
// a) check for the presence of node.left, and then make the node's right node as left node's next node
// b) Check for the presence of node.right, and then make the node's right next node as node's left's next node
// c) Jump through every levels until the node reaches the last level of tree

// Time complexity: o(n)
// space complexity: o(1)

// did it run on leetcode: yes

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
        while(start!=null) {
            Node curr = start;
            while(curr!=null) {
                if(curr.left!=null) curr.left.next = curr.right;
                if(curr.right!=null && curr.next!=null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            start = start.left;
        }
        return root;
    }
}