//TC - O(n)
//SC - O(h)
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
    Node first;
    Node second;
    Node prev;
    public Node connect(Node root) {
        //dfs
        if(root == null) return root;
        helper(root);
        return root;
    }
    private void helper(Node root){
        if(root.left == null) return;
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }
        helper(root.left);
        helper(root.right);
    }
}
