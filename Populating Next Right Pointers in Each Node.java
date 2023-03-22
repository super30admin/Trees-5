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
        
        //So another way is to first do the processing and then proceed to the next node.
        //Mark the root.next as null since it will never have any neighbor
        if(root == null){
            return root;
        }
        root.next = null;
        
        helper(root);
        return root;
    }
    
    public void helper(Node root){
        
       if(root == null){
           return;
       }
        
        if(root.left != null){
            root.left.next = root.right;
        }
        
        if(root.right != null){
            if(root.next != null){
                root.right.next = root.next.left;
            }
            
            else{
                root.right.next = null;
            }
            
        }
        
        helper(root.left);
        helper(root.right);
    }
}