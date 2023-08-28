// TC = O(n)
// SC = O(1)
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
    Node level;
    Node curr;
    public Node connect(Node root) {
        if(root == null) return root;
        level = root;
        
        while(level.left!=null){
            curr = level;
            while(curr!=null){
                // Every parent has 2 children
                curr.left.next = curr.right;    
                if(curr.next!=null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level =level.left;
        }
        return root;
    }
}