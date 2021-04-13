//TC: O(n)-->traveling through each node 
//SC: O(1)
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
        if(root==null)
            return root;
        Node node = root;   //Doing level order traversal
        while(node!=null)   //As tree is perfect binary search tree, if root has left child assigning right child as the next of left child
        {
            Node curr = node;   //If root has next value assigning right next to root's next's left. and traversing till current has next.
            if(curr.left==null || curr.right==null)
                break;
            while(curr!=null)   // As every time we are working on child nodes, when you encounter leaf node break the loop.
            {
                if(curr.left!=null)
                    curr.left.next = curr.right;
                if(curr.next!=null)
                    curr.right.next = curr.next.left;                   
                curr = curr.next;
            }
            node = node.left;
        }
        return root;
    }
}