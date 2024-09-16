// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We use InOrder Traversal to iterate throgh the tree to find the element which doesn't fit in.
*/

class Solution {
    
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    
    public void recoverTree(TreeNode root) {
        prev = null;
        first = null;
        second = null;
        
        inOrderTravrsal(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public void inOrderTravrsal(TreeNode root) {
        
        if (root == null) return;
        
        inOrderTravrsal(root.left);
        
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }
        
        prev = root;
        
        inOrderTravrsal(root.right);
    }
}