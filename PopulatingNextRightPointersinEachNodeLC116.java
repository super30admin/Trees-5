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
    
    
    
    //Approach 4, DFS Approach
    
    //Time Complexity: O(n)
    //Space Complexity: O(h), recursive stack space
    
    public Node connect(Node root) {
        
        if(root == null || root.left == null){  //because of complete binary tree, we can check null condition for only one child
            return root;
        }
        
        root.left.next = root.right;
        
        if(root.next != null){
            root.right.next = root.next.left;
        }
        
        connect(root.left);
        connect(root.right);
        
        return root;
    }
    
    
    
    
    
    //Approach 3, DFS Approach
    
    //Time Complexity: O(n)
    //Space Complexity: O(h), recursive stack space
    
    
//     public Node connect(Node root) {
     
//         if(root == null) return root;
//         helper(root.left, root.right);
//         return root;
//     }
    
//     private void helper(Node left, Node right){
        
//         //base
//         if(left == null) return;    //because of complete binary tree, we can check null condition for only one child
        
//         //logic
//         left.next = right;
        
//         helper(left.left, left.right);
//         helper(left.right, right.left);
//         helper(right.left, right.right);
//     }
    
    
    
    
    
    //Approach 2, Optimized BFS
    
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    
    
//     public Node connect(Node root) {
     
//         if(root == null) return root;
        
//         Node level = root;
        
//         while(level.left != null){
            
//             Node curr = level;
            
//             while(curr!= null){
                
//                 curr.left.next = curr.right;
                
//                 if(curr.next!= null){
//                     curr.right.next = curr.next.left;
//                 }
//                 curr = curr.next;
//             }
//             level = level.left;
//         }
//         return root;
//     }
    
    
    
    
    
    
    
    //Approach 1, Brute-force BFS
    
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    
    
//     public Node connect(Node root) {
     
//         if(root == null) return root;
        
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
        
//         while(!q.isEmpty()){
            
//             int size = q.size();
//             Node prev = null;
            
//             for(int i=0; i<size; i++){
                
//                 Node curr = q.poll();
                
//                 if(i!=0){
//                     prev.next = curr;
//                 }
//                 prev = curr;
                
//                 if(curr.left != null){          //because of the complete binary tree, we dont have to check both the child exist or not, only one check is enough
//                     q.add(curr.left);
//                     q.add(curr.right);
//                 }     
//             }
//         }
//         return root;
//     }    
}
