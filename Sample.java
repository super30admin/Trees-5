// Time Complexity : O(n)
// Space Complexity : O(n)
// Your code here along with comments explaining your approach
// Approach: Recursively make a node point to next node. 
// Make left child of left child point to its sibling
// Make right child of left child point to its immidiate cousin.
// Make left child of right child point to its sibling

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
        if(root==null) return root;
        func(root.left,root.right);
        return root;
    }
    public void func(Node node1, Node node2){
        if(node1==null) return;
        node1.next = node2;
        func(node1.left,node1.right);
        func(node1.right,node2.left);
        func(node2.left,node2.right);
    }
}
