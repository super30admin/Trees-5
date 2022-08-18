//Time Complexity: O(n)
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem1_2 {

    public Node connect(Node root){
        
        if(root == null)
          return null;
         
         Node lvl = root;
         
         while(lvl.left!= null){
             
             Node curr = lvl;
             
             while(curr != null){
                 
                 if(curr.left != null){
                     curr.left.next = curr.right;
                 }
                 
                 if(curr.next != null){
                     curr.right.next = curr.next.left;
                 }
                 
                 curr = curr.next;
             }
             lvl = lvl.left;
         }
       return root;
     }
}
