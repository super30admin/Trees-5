// Time Complexity : Add : O(N),
// Space Complexity : O(H), H-Height of binary Tree
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
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        
        inorder(root);
        
        //swap the violated nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }
    
    private void inorder(TreeNode root){  // T.C - O(N), S.C-O(H), H-Height of tree
        // base
        if(root == null)
            return;
        
        //logic
        inorder(root.left);
        
        //check
        if(prev!=null && root.val < prev.val){
            if(first == null && second == null){
                //first violation
                first = prev;
                second = root;
            } else {
                //second violation
                second = root;
            }
        }
        
        prev = root;  //keep updating the prev
        
        inorder(root.right);
    }
}
