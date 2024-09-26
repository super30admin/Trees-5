//TC: O(n)
//SC: O(n)

public class recover_bst {
    class Solution {
        // Creating three global pointers
       TreeNode previous = null;
       TreeNode first = null;
       TreeNode second = null;
       
       public void recoverTree(TreeNode root) {
           // Finding the two swapped nodes
           solve(root);
           
           int temp = first.val;
           first.val = second.val;
           second.val = temp;
       }
        
       public void solve(TreeNode root){
           
           if(root == null){
               return;
           }
           
           //Doing inorder traversal 
           solve(root.left);
           
           
           if(previous != null && root.val < previous.val){
               
               //Storing previous node
               if(first == null){
                   first = previous;
               }
               
               
               second = root;
               
           }
           
          
           previous = root;
           
           
           solve(root.right);
           
       }
   }
}
