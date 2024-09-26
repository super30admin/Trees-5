// Time complexity - O(n)

// Space complexity - O(1)

// Inorder traversal with pointers

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
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int tmp = first.val;
        first.val = last.val;
        last.val = tmp;
    }
    
    private void inorder(TreeNode root){
        // base
        if(root == null) return;
        // logic
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            if(!flag){
                flag = true;
                first = prev;
                last = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
