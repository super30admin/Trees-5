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
// Idea here is to perform inorder traversal by using level for current level
// not we can link all the nodes on current level by linking first current's left and right
// and keep going to next of current, then when current reaches end of that level
// we go to next level and do the same thing
class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Node level = root;
        Node curr = null;
        while(level.left!=null) {
            curr = level;
            while(curr!=null) {
                curr.left.next = curr.right;
                if(curr.next!=null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}