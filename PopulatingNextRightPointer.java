//Time complexity- O(n)
//Space Complexity- O(1)
//Sucessfully ran on leetcode

class Solution {
 public Node connect(Node root) {
     if( root == null) return null;
     
     Node lvl= root;
     Node curr= null;
     
     while(lvl.left != null){
         curr = lvl;
         
         while(curr!= null){
             curr.left.next = curr.right;

             if(curr.next != null){
                 curr.right.next = curr.next.left;
             }
             curr = curr.next;
         }
         lvl= lvl.left;
     }
     return root;
 }
}