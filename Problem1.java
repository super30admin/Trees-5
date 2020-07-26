// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

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
        Node level, curr;
        level = curr = root;
        
        while(level != null){
            curr = level;
            while(curr != null){
                //is next in order is not null
                if(curr.right != null)
                    curr.left.next = curr.right;
                //if its sibling from other branch is not null
                if(curr.next != null && curr.next.left != null)
                    curr.right.next = curr.next.left;
                
                curr = curr.next;
            }
            // going down the level
            level = level.left;
        }
        
        return root;
    }
}