// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
If root is null or either of root's children are null, I simply return root. I call my helper function on left and right child of root.
If either of left or right child is null, I return from the helper function. I then connect left.next to right node. I then
recursively call the helper function on (left.left, left.right) , (left.right, right.left) and (right.left, right.right).
*/

/*
// Definition for a Node.
public class Node {
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
}
*/

public class Solution {
    public Node Connect(Node root) {
        
        if(root == null || root.left == null)
        {
            return root;
        }

        DFS(root.left, root.right);

        return root;
    }

    public void DFS(Node left, Node right)
    {
        if(left == null || right == null)
        {
            return;
        }

        left.next = right;

        DFS(left.left, left.right);
        DFS(left.right, right.left);
        DFS(right.left, right.right);
    }
}