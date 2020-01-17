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

/**
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(Number of total nodes)

The idea is to use pointers level and current at each levels of the BT such that we traverse in level fashion. The idea here is to manipulate next pointer of children of the tree from the parent node itself to avoid using Queue and additonal space.


**/
class Solution {
    public Node connect(Node root) {
        
        if(root == null)
            return root;
        
        //Intitialize level node to root
        Node level = root;
        
        while(level != null){
            //Assign curr to level
            Node curr = level;
            
            while(curr != null)
            
            {
                if(curr.left != null)
                    curr.left.next  = curr.right;
                
                if(curr.right != null && curr.next != null)
                    curr.right.next = curr.next.left ;
            
                //Increase current pointer till we traverse all node of the level
                curr = curr.next;
                
            }
            
            //Increase level pointer by assign to left node to next level
            level = level.left;
            
        }
        
        return root;
    }
}
