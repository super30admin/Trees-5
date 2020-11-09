// Time Complexity : O(n)  
// Space Complexity : O(log n), call stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// do inorder traversal of the tree, in the process check if curNode.val < prev, keep track
// swap values when this occurs the second time


class Solution {
    TreeNode first, second, prev;
    
    public void recoverTree(TreeNode root) {    
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void helper(TreeNode root){
        if(root!=null){
            helper(root.left);
            
            if(prev!=null && (root.val<prev.val)){
                if(first==null){
                    first = prev;
                    second = root;
                }
                else{
                    second = root;
                }
            }
            
            prev = root;
            helper(root.right);
        }
    }
}