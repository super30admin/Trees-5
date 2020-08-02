//Time Complexity : O(n)
//Space Complexity : O(n)
//Did it run on leetcode : yes

class Solution {
    TreeNode prev;
    TreeNode x;
    TreeNode y;
    boolean flag;
    public void recoverTree(TreeNode root) {
     
        if(root == null)
            return;
        flag = false;
        helper(root);
        int temp = x.val;
        x.val = y.val;
        y.val = temp; 
         return;  
            
    }
    
    private void helper(TreeNode root){
    
        if(root == null)
            return;
        helper(root.left);
        if(prev!=null && prev.val > root.val){
           if(flag == false){
             x = prev;      
           }
           y = root;
           flag = true;
        }
        prev= root;
        helper(root.right);
        
    }
}