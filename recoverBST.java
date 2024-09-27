// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) for the recursive stack space where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Traversing the tree inorder and noting the nodes which violate the BST property
// Then swap the values in the violating nodes

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class recoverBST {
    
    TreeNode prev, first, mid, last;
    
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        inorder(root);
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && mid != null) {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }
    
    private void inorder(TreeNode root) {
        // base case
        if (root == null) return;
        // logic
        inorder(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                mid = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}