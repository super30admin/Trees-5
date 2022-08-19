TC: O(N)
SC: O(1)

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
    TreeNode curr;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        curr = root;
        // prev = r
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {

        if(root == null) return;

        inorder(root.left);
        curr = root;
        if(prev != null) {
             if(prev.val >= curr.val) {
                 if(first == null) {
                     first = prev;
                     second = curr;
                 } else {
                     second = curr;
                 }
            }
        }
        prev = curr;


        inorder(root.right);
    }
}
