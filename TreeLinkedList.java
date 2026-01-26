// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Each node processes 2 connections -> child left to child right and child right to sibling left
// Maintain a level pointer to traverse next nodes
// once a level is complete, move to the next level using left


class Solution {
    public Node connect(Node root) {
       if(root != null)
           helper3(root.left,root.right);
       return root;
   }

   // level implementation
    private void helper(Node level){
        
        while(level.left != null){
            Node curr = level ;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
    }

    // recursive
   private void helper1(Node root){
       if(root.left == null) return;
       
       root.left.next = root.right;
       if(root.next != null){
           root.right.next = root.next.left;
      
        }
       helper1(root.left);
       helper1(root.right);
   }

   private void helper3(Node left, Node right){

    if(left == null) return;
    
    left.next = right;

    helper3(left.left, left.right);
    helper3(left.right, right.left);
    helper3(right.left, right.right);
    
}

} 