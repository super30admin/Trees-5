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
//TC: O(n) sc :O(1)
        if( root==null )return root;
        Node level=root;
        while (level.left!=null){ //until next level exists
          Node  curr=level;
            while(curr!=null){//process current level
            curr.left.next=curr.right;
            if(curr.next!=null)
             curr.right.next=curr.next.left;
            curr=curr.next;
            }
        
        level=level.left;
        
        
    }
        return root;
    
}}
