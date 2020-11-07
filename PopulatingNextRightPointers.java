// Time Complexity : O(n - 2^h)  
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// form connections at level N+1 at level N
// make connection 1 as connect level N node's left child to right child, then connection 2 as node.right.next = node.next.left

class Solution {
    public Node connect(Node root) {
        if(root==null)
            return root;
        
        Node level = root;
        
        while(level.left!=null){
            Node head = level;
            
            while(head!=null){
                head.left.next = head.right;
                
                if(head.next!=null){
                   head.right.next = head.next.left;  
                }
                
                head = head.next;
            }
            
            level = level.left;
        }
        
        return root;
    }
}