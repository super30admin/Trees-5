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

/*
Brute force way would be to do level order traversal and while doing level order traversal keep connecting the nodes at the same level. But that would take extra space for storing the nodes in the queue. 


*/
class Solution {
    public Node connect(Node root) {
        Node dummy = new Node(-1);
        Node ptr = dummy;
        Node cur = root;
        while(root != null){
            if(root.left != null){
                ptr.next = root.left;
                ptr = ptr.next;
            }
            if(root.right != null){
                ptr.next = root.right;
                ptr = ptr.next;
            }
            root = root.next;
            if(root == null){
                ptr = dummy;
                root = dummy.next;
                dummy.next = null;
            }
        }
        return cur;
    }
}
