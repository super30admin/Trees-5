// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
        //edge
        if(root == null) return null;
        //set a level pointer to move down levels later
        Node level = root;
        //start a while loop that goes through all levels until null
        while(level.left != null){
            //set the cur to level 
            Node cur = level;
            //start a while loop that goes through a single level until null
            while(cur != null){
                //if the the next is not null the set pointer
                //iterate on the level 
                cur.left.next = cur.right;
                if(cur.next != null){
                    cur.right.next = cur.next.left;
                }
                //move cur over to the next one
                cur = cur.next;
            }
            //move level down
            level = level.left;
        }
        return root;
    }
}
