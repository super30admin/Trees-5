// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity :O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner approach of your code in plain English
//1. Take 2 pointers, one to track the level and one to track all the nodes at one level
//2. At each level, at the current node, populate a next right pointer from current's left node to the right node AND populate the next right 
        //pointer from cuurent's right node to currrent's next siblings's left node (If next sibling exists)
//. Continue doing this till level has not reached the leaf level (level.left != null)

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
        //edge case
        if(root == null) return null;
        Node level = root;
        
        //traverse all the levels of the binary tree
        while(level.left != null){
            //2 pointers, one for going to the next level and one for going to all the      nodes at that level
            //Node level = root;
            Node curr = level;
            
            //traverse all the nodes at each level
            while(curr != null){
                //populate the next right pointer from the left child to the right child of curr
                curr.left.next = curr.right;
                //populate the next right pointer from the current's right child to the current's sibbling's left child
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                //move current to the next node in the same level
                curr = curr.next;
            }
            //move level to the next level in the tree
            level = level.left;
        }
        return root;
    }
}