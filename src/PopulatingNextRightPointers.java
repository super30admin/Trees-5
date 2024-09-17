// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/* O(n) time O(1) space solution using bfs, we dont need queue since next pointers we create, maintain level order nodes
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
 * 
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
        if(root == null) return root;
        
        Node curr = root;
        while(curr.left != null) {
            
            Node temp = curr;
            
            while(temp != null){
                temp.left.next = temp.right;
                
                //if next node in level is not null, link between right child of current node
                //and left child of next node
                if(temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                //go to next node in the level
                temp = temp.next;
            }
            
            curr = curr.left;
        }
        
        return root;
    }
}