/*
TC: O(n) n: no of nodes
SC: O(h) h: height of the tree. if skewed then O(n).
Approach: Do Inorder traversal of the tree and keep track of prev, first and econd pointer, where prev belong to the parent of node, first is the first violation of BST property and seconf id second violation of BST property. At the end once all nodes are visited, swap the first and second.
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
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        this.first = null;
        this.second = null;
        this.prev = null;

        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root){
        if(root == null) return;

        helper(root.left);

        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }

        prev = root;
        helper(root.right);
    }
}