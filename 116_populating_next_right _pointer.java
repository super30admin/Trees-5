    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/recover-binary-search-tree/
    Time Complexity for operators : o(e+v) .. vertices + edges
    Extra Space Complexity for operators : o(1)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Do level order traversal and if we are at last node then make last node pointing to the next in a queue.
                           For this time complexity will be same as above but space will be o(n).
        # Optimized approach: 
                              
            # 1. 
                    A) Start the loop while level.left is not equal to null. Store current pointer with level.
                    B) while current is not null, move curr.left.next = curr.right;
                    C) Also, during this iteration, check if current.next is null if it is then point this to
                            curr.right.next = curr.next.left;
                    D) Move current and level accordungly.
    */ 

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
        
        if(root==null)
            return root;
        
        
        
//        Queue<Node> queue = new LinkedList<>();
        
//         queue.add(root);
        
//         while(!queue.isEmpty()){
//             int size = queue.size();
            
//             for(int i=0;i<size;i++){
//                 Node node = queue.poll();
                
//                 if(i<size-1){
//                     node.next = queue.peek();
//                 }
                
//                 if(node.left!=null) queue.add(node.left);
//                 if(node.right!=null) queue.add(node.right);

//             }
//         }
//         return root;
        
        // optmized one
        Node level = root;
        Node curr = root;
        while(level.left!=null){
            curr = level;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next!=null){
                    curr.right.next = curr.next.left;
                }
                
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}