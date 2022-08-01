// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
class RecoverBST {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        swap(first,second);
    }
    
    private void inOrder(TreeNode root) {
        if(root == null)
            return;
        
        inOrder(root.left);        
        if(prev != null && prev.val >= root.val){
            if(first == null){
                first = prev;
                second = root;
            }else{
                second = root;
            }
        }
        
        prev = root;
        inOrder(root.right);
        
    } 
    
    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
