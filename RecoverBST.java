// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

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

 // In inorder traversal, we identify 2 nodes that violate BST property
 // Identify first and second nodes and swap values

class Solution {
    
    TreeNode prev, first, second;
    
    public void recoverTree(TreeNode root) {
        
        if(root == null) return;
        
        Stack<TreeNode> s = new Stack<>();
        
        while(root != null || !s.isEmpty()) {
            
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            
            if(prev != null && prev.val >= root.val) {
                if(first == null) {
                    first = prev; // First node violating BST property
                }
                second = root; // Second node violating BST property
            }
            prev = root;
            root = root.right;
        }
        int temp = first.val; // Swap
        first.val = second.val;
        second.val = temp;
    }
}