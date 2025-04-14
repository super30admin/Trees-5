//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//LC:116
//Time Complexity - o(n) - have to touch every node
//Space complexity =O(1) - Constant

/*
call root node left.
while left.left is not null do the following
Take a pointer called cuur to traverse and initialise left to curr.
while curr is not null repeat following
curr.left.next  = curr.right
if curr.next not null
curr.right.next = curr.next.leftcurr = curr.next
left - left.left
return root.

 */

public class PopulatingNextRight {
    public Node connect(Node root) {
        // base case, if root is null return null
        if (root == null) {
            return null;
        }

        Node left = root;
        Node curr;
        while (left.left != null) {
            curr = left;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            left = left.left;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

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


}
