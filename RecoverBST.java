//Time complexity=O(n)
//Space complexity=O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

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
    TreeNode first;
    TreeNode last;
    boolean flag;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null)return;
        inorder(root);
        int temp = last.val;
        last.val = first.val;
        first.val = temp;
        
    }
    private void inorder(TreeNode root){
        
        //base
        if(root == null)return;
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