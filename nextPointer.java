// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach

class Solution {
    public Node connect(Node root) {
        
        if(root == null)
            return root;
        
        Node leftmost = root;
        
        while(leftmost.left != null) {
            
            Node curr = leftmost;
            
            while(curr != null) {
                curr.left.next = curr.right;
                if(curr.next != null)
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }            
            
            leftmost = leftmost.left;
        }
        
        return root;
    }
}