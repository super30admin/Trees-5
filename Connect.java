// Time Complexity : O(n) 
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach:As we traverse in level prder through each node, put the next pointer of its left child to its
// right child. Also put the next pointer of its right child to its next pointer left child.
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
        Node level = root;
        while(level.left!=null){
            Node curr = level;
            while(curr!=null){
                curr.left.next= curr.right;
                if(curr.next!=null){
                    curr.right.next=curr.next.left;
                }
                curr=curr.next;
            }
            level=level.left;
        }
        return root;
    }
}