// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode prev,first,middle,last;
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        inorder(root);
        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }else if (first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
    
    private void inorder(TreeNode root){
        //base case
        if(root == null){
            return;
        }
        //logic
        
        inorder(root.left);
        
        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}