// Time Complexity : O(n)
// Space Complexity : O(h) h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Find the first and second element which are not in order using inorder traversal.
 * 2. Swap the first and second element.
 */

class Solution {
    TreeNode prev, first, second;
    public void recoverTree(TreeNode root) {
        helper(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void helper(TreeNode root){
        if(root == null)
            return;
        
        helper(root.left);
        if(prev != null && prev.val >= root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        helper(root.right);
    }
}