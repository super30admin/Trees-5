// Time Complexity : O(n)
// Space Complexity : O(log n)

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
    TreeNode second;
    TreeNode prev;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp; 
    }
    
    private void inOrder(TreeNode root){
        //base
        if(root == null)
            return;
        //logic
        inOrder(root.left);
        if(prev != null && prev.val >= root.val){
            if(!flag){
                first = prev;
                second = root;
                flag = true;
            }
            else{
                second = root;
                return;
            }
        }
        prev = root;
        inOrder(root.right);
    }
}