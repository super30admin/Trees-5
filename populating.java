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
// TC: O(n), sc:O(h)
class Solution {
    public Node connect(Node root) {
        
        if(root==null) return null;
        dfs(root);
        return root;
    }

    private void dfs(Node root){
        if(root.left==null) return;

        root.left.next=root.right;
        if(root.next!=null){
            root.right.next=root.next.left;
        }
        dfs(root.left);
        dfs(root.right);
    
    }
}