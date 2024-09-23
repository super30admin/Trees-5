// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.
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
    //DFS
    public Node connect(Node root) {
        if(root == null) return root;
        helper(root.left, root.right);
        
        return root;
    }

    private void helper(Node left, Node right){
        //base
        if(left == null) return;

        //logic
        left.next = right;
        helper(left.left,left.right);
        helper(left.right,right.left);
        helper(right.left,right.right);
    }
}