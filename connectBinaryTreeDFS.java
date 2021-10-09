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
// Time : O(n)
// Space: O(1)
// Idea here is to perform perform dfs on both left and right subtree and assigning left's next to right each time
// performing dfs on left's left and left's right cover immediate parent on left subtree
// left's right and rights left cover disjoint subtrees
// right's left and right's right right subtree links
class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        dfs(root.left, root.right);
        return root;
    }
    
    public void dfs(Node left, Node right) {
        if(left==null) return;
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }
};