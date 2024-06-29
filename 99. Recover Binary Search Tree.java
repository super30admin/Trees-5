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
// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : Inorder Traversal

class Solution {

    TreeNode prev = null, node1 = null, node2 = null;

    public void recoverTree(TreeNode root) {

        inOrder(root);

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private void inOrder(TreeNode root)
    {
        if(root == null) return;

        inOrder(root.left);

        if(prev != null && prev.val > root.val)
        {
            if(node1 == null)
            {
                node1 = prev;
                node2 = root;
            }

            else node2 = root;
        }

        prev = root;

        inOrder(root.right);
    }
}
