/**
 * Time Complexity : O(n) where n is the number of nodes 
 * Space Complexity : O(n) where n is the number of recursive stack calls 
 */

public class RecontructBST {
    TreeNode first = null;
    TreeNode last = null;                                                       
    TreeNode prev = null;
    int flag = 0;
    public void recoverTree(TreeNode root) {
     if(root == null){return;}
     inorder(root);                                                                         
     int temp = first.val;
     first.val = last.val;                                                                     
     last.val = temp; 
    }
    private void inorder(TreeNode root){
        if(root == null){return;}
        inorder(root.left);                                                                 
        if(prev != null && prev.val > root.val){                                                
                if(flag == 1){
                last = root;                                                                    
                } else{
                first = prev;
                last = root;                                                                   
                flag = 1;
                }
            }
            prev = root;                                                                     
        inorder(root.right);                                                                
        }
}

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