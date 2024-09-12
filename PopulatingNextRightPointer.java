// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Like two pointer, one to move for the mostleft and another 
// to move the list.
class Solution {

    // ************************* Optimal *****************
    // Time: O(n) Space O(1)
     public Node connect(Node root) {
        if(root == null)
            return null;
         
         Node level = root;
         Node curr = root;
         
         while(level.left != null){
             curr = level;
             while(curr!=null){
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
    
    // ************************* Level order tranversal *****************
    // Time: O(n) Space O(n)
    public Node connect_levekl_order(Node root) {
        if(root == null)
            return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node prev = null;
        
        while(!q.isEmpty()){
            int size = q.size();
            prev = null;
            for(int i=0; i<size; i++){
                Node curr = q.remove();
                
                if (prev !=  null){
                    prev.next = curr; 
                }
                
                prev = curr;
            
                if(curr.left!= null){
                    q.add(curr.left);
                }
                if(curr.right!= null){
                    q.add(curr.right);
                }
            }
        }
        return root;     
    }
}