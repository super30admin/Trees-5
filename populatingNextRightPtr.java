/**
TC: O(n) n: no of nodes.
SC: O(1) no extra space used
Approach: i will start from leftMost node and keep populating the next uing the root's right node as well as root's next.
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
        if(root == null) return null;
        Node leftMost = root;

        while(leftMost.left != null){
            Node head = leftMost;

            while(head != null){
                //conn1
                head.left.next = head.right;

                //conn2
                if(head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }


        leftMost = leftMost.left; 
        }
    return root;  
    }
}