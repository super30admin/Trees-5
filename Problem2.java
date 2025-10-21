// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Since we have to find the breach in BST, we can do the in order traversal and find the breaches.
 * If the breach is parent child nodes, then there will be only one breach in the tree.
 * If the breach is not parent child nodes, then there will be two breaches in the tree.
 *
 * In both cases, we will keep track of first and second pointers. At the end of the inorder traversal, we will replace the values of first and second breaches.
 */
class
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;

        inorder(node.left);
        if (prev != null && prev.val >= node.val) {
            // first breach
            if (first == null) {
                first = prev;
                second = node;
            }
            //second breach
            else {
                second = node;
            }
        }
        prev = node;

        inorder(node.right);
    }
}