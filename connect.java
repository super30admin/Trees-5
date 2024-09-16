// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// use level order using two pointers
public class Solution {
    
    public Node connect(Node root) {
        
        Node level=root;
        
        while(level!=null){
            
            Node cur=level;
            while(cur!=null){
                
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
                cur=cur.next;
            }
            level=level.left;
        }
        
        return root;
        
    }
}
