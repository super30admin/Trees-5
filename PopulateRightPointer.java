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
        if(root == null){
            return root;
        }
        
        //keeping track of left most node
        Node level = root;
    
        //level order traversal
        while(level != null){
            Node curr = level;
            
            //no need to perform ant operation at leaf nodes
            if(curr.left == null && curr.right == null){
                break;
            }
            
            //at each level connecting its left and right nodes 
            while( curr!= null){
                if(curr.left != null){
                    curr.left.next =  curr.right;
                }
                
                //connecting last element of left subtree at a level to first element of right sub tree in the same level
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            
            level = level.left;
        }
        
        return root;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)