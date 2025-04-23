//Time Complexity : O(n) where n is the no of nodes.
// Space Complexity : O(h) h is the height of the tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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


class Solution {
    private void dfs(Node root)
    {
        if(root == null) return;

        if(root.left != null)
            root.left.next = root.right;
        if(root.right != null && root.next != null)
            root.right.next = root.next.left;
        
        dfs(root.left);
        dfs(root.right);
    }
    public Node connect(Node root) {
        dfs(root);
        return root;
    }
}