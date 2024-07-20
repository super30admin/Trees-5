/*
    LC - 99. Recover Binary Search Tree
    TC - O(N)
    SC - O(h)
    Approach -
        using the bst property and dfs inorder traversal
        using previous, find the first & second
        swap both
*/

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
    TreeNode first, second;
    int cnt = 0;
    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }

        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root) {
        // base
        if(root == null || cnt == 2) {
            return;
        }
        inorder(root.left);
        if(prev !=null && prev.val > root.val) {
            cnt++;
            if(first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}