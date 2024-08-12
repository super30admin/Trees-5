
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
 * TC --> O(n)
 * SC --> O(1)
 */
class Solution {

    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        Helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    public void Helper(TreeNode root) {
        if (root == null) {
            return;
        }
        Helper(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                second = root;
            }//if
            else {
                second = root;
            }

        }//if
        prev = root;
        Helper(root.right);

    }//method
}//class
