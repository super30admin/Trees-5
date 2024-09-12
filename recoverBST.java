// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

 class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
        TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

public class recoverBST {
    TreeNode first;
    TreeNode last;
    TreeNode prev;
    boolean flag;
    public void recoverTree(TreeNode root) {
        
        if(root==null)
            return;
        
        inorder(root);
        int temp=first.val;
        first.val=last.val;
        last.val=temp;
        
        
    }
    
    private void inorder(TreeNode root){
        //base
        if(root==null)
            return;
        
        //logic
        
        inorder(root.left);
        if(prev !=null && prev.val >=root.val ){
            if(!flag){
                first=prev;
                last=root;
                flag=true;
            }else{
                last=root;
            }
        }
        
        
        
        prev=root;
        inorder(root.right);
    }
}
