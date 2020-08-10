// Time Complexity : O(n) --> where n is the number of nodes in the tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (99): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    TreeNode first; TreeNode last;
    TreeNode prev; boolean flag;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        swap(first, last);
    }
    
    private void inorder(TreeNode root) {
        // base case
        if (root == null) return;
        
        // logic
        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (!flag) {
                first = prev;
                last = root;
                flag = true;
            }
            else last = root;
        }
        prev = root;
        inorder(root.right);
    }
    
    private void swap(TreeNode i, TreeNode j) {
        int temp = i.val;
        i.val = j.val;
        j.val = temp;
    }
}