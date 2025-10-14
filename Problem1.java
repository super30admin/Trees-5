// 116. Populating Next Right Pointers in Each Node

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

/*
Ran on leetcode: Yes
TC: O(n) SC: O(1)
Move level by level iteratively, and on each level, visit all nodes on the same level and connect all the siblings and cousins
*/
class Solution {
    public Node connect(Node root) {

        if(root == null) return null;

        Node level = root;

        // Move until one node before leaf, cauz we are making changees to node below it
        while(level.left != null){
            Node curr = level;
            // Visit all the nodes on the same level
            while(curr != null){
                // Connect both siblings 
                curr.left.next = curr.right;
                // Connect both cousins
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                // Move to next node on the same level
                curr = curr.next;
            }
            // Move to next level
            level = level.left;
        }

        return root;
    }
}