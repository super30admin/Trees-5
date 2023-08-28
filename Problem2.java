// Time: O(N)
// Space: O(N)

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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    // TreeNode next = new TreeNode(Integer.MAX_VALUE);
    public void recoverTree(TreeNode root) {

        inorder(root);
        int temp  = this.first.val;
        first.val = second.val;
        second.val = temp;
        return;
    }

    private void inorder(TreeNode root){
        if(root == null)
            return;

        inorder(root.left);
        // 
        if(first == null && (prev ==null ||root.val <= prev.val)){
            first = prev;
        }

        if(first != null && root.val<= prev.val){
            second = root;
        }
        prev = root;
        
        
        inorder(root.right);
    }
}