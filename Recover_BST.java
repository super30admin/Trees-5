/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode last;
    Boolean flag = false;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
        
    }
    private void inorder(TreeNode root){
        //base
        if(root == null) return;
        
        //logic
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            if(!flag){
                first = prev;
                last = root;
                flag = true;
            }else{
                last = root;
            }
            
        }
        prev = root;
        inorder(root.right);
    }
}

//TC: O(N)
//SC: O(1)
