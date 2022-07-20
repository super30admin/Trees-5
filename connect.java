//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
// Time Complexity :O(n)  
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

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
        if(root==null) return root;
        Node level=root;
        Node curr; //moves right ie to next in the current level
        while(level.left!=null)
        {
            curr=level;
            while(curr!=null)
            {
                curr.left.next=curr.right;
                if(curr.next!=null)
                {
                    curr.right.next=curr.next.left;
                }
                curr=curr.next;
            }//all nodes in the next level are connected move to next level
            level=level.left;

        }
        return root;


    }
} 