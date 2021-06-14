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

//time- o(n)
//space- o(1)

class Solution {
    public Node connect(Node root) {
        
        if(root == null) return root;
        
        Node level = root;
        Node curr = root;
        
        while(level.left!=null)
        {
            curr = level;
            while(curr!=null)
            {
                 curr.left.next = curr.right;
                 if(curr.next!=null)
                 {
                      curr.right.next = curr.next.left;
                 }
                
                 curr = curr.next;
            }
            
            level = level.left;
        }
        
        return root;
    }
}


//can do using bfs- queue--
//time-o(n), space-o(n)

/*for every node polled, do below
      
      curr.left.next = curr.right;
                 if(curr.next!=null)
                 {
                      curr.right.next = curr.next.left;
                 }
Just check, if left child and right child present, 
as it will not be prsent for 4,5,6 etc- leaf nodes*/
                