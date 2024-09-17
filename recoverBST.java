// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    TreeNode prev, first, second;
    public void recoverTree(TreeNode root) {
        
        if(root == null)
            return ;
        
        inorder(root);
        
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
        
        return ;
    }
    
    public void inorder(TreeNode node) {
        if(node == null)
            return;
        // System.out.println(node.val);
        inorder(node.left);
        if(prev != null && prev.val >= node.val) {
            if(first == null) {
                first = prev;
            }
            second = node;
            // System.out.println(first.val);

        }
        
        prev = node;
        
        
        inorder(node.right);
        
    }
    
}