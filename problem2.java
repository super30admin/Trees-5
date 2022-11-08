package s30.Trees-5;

public class problem2 {
    class Solution {
        //TC:- O(h)
        //SC:- O(h)
        TreeNode prev, first, second;
        public void recoverTree(TreeNode root) {
            if(root == null) return;
            
            helper(root);
            
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        
        private void helper(TreeNode root){
            //base
            if(root == null) return;
            
            //logic
            helper(root.left);
            if(prev != null && prev.val >= root.val){
             if(first == null){
                     first = prev;
                     second = root;  
            }
            else{
              second = root;  
            }
        }
            prev = root;
            helper(root.right);
        }
    }
}
