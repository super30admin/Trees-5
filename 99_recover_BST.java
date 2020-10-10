    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/recover-binary-search-tree/
    Time Complexity for operators : o(e+v) .. vertices + edges
    Extra Space Complexity for operators : o(n)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Do inorder and get the traversal and then check which one is not in sorted order.
        # Optimized approach: 
                              
            # 1. 
                    A) Do inorder traversal on the given tree. Add all left nodes into stack and then pop and go to right one by one.
                    B) After pop,check for few things. First store the value of popeed node 
                    C) If we found wrong node, The inorder of BST is always Sorted order.
                    D) In each iteration, we will check the value of previous node with the current 
                    E) If current if less then previos then we found the wrong node
                    F) change value of x to treenode and y to previous if it is null
                    G) At the end, swap those nodes.
    */ 


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
class Solution {
    public void recoverTree(TreeNode root) {
        
        if(root==null) return;
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode x = null;
        TreeNode y = null;
        TreeNode prev = null;
        
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.add(root);
                root = root.left;
            }
            
            TreeNode treeNode = stack.pop();
            
            if(prev != null && prev.val > treeNode.val){
                // found wrong node
                x = treeNode;
                if(y == null){
                    y = prev;
                }else{
                    break;
                }
            }
            
            prev = treeNode;
            
            root = treeNode.right;
        }
        
        swap(x,y);
    }
    
    private void swap(TreeNode x, TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}