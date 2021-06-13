//Time complexity O(n)
//Space complexity O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

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
//The logic used in the algo is as the tree is perfect binary tree, instead of using queue, I can just use 2 pointers. One pointer level will tell me what's the current level I am iterating on and other pointer will create the connections to the right child of current left node so that we can iterate on each level like a linked list.
class Solution {
    public Node connect(Node root) {
        
        if(root == null){
            
            return root;
        }
        
        Node level = root;
        Node curr = root;
        Node point = root;
        
        while(level.left != null){
            
            curr = level;
            root = curr;
            
            while(root != null){
                 //  System.out.println(root.val);
                root.left.next = root.right;
                if(root.next != null){
                    root.right.next = root.next.left;
                }
                
                root = root.next;
               }     
                 
                  level = curr.left;
        }
        
        return point;
    }
}