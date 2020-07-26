// Time Complexity : O(n) n = number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach


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
    TreeNode p, q, prev;
    boolean flag;
    
    public void recoverTree(TreeNode root) {
        // base case - root == null
	if(root == null) return;
        // inorder traversal
	traverse(root);
        
	// reordering the tree
	int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
    
    private void traverse(TreeNode root){
        if(root==null) return;
        
        traverse(root.left);
        
        if(prev != null && prev.val>=root.val){
            if(!flag){
                flag = true;
                p = prev;
                q = root;
            }
            else{
                q = root;    
            }
        }
        
        prev = root;
        
        traverse(root.right);
    }
}