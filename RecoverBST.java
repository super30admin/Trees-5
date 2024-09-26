/**
You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
Time Complexity : O(N)
Space Complexity : O(Height of Tree)
Worked on Leetcode YES
**/



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



// simple inorder traversal and maintain the reference of nodes to swap
class Solution {
    TreeNode X1;
    TreeNode Y1;
    TreeNode prev  = null;
    public void recoverTree(TreeNode root) {
        
        dfs(root);
        
        swap(X1,Y1);
      
    }
    
    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node2.val;
        node2.val = node1.val;
        node1.val = temp; 
    }
    
    private void dfs(TreeNode curr) {
       if (curr == null )return ;
        // traverse left
        dfs(curr.left);
        
        // condition check or traversal
        // check if prev is greater than current then we find our node 
        
        if(prev != null && prev.val > curr.val) {
            if(X1 == null ) {
                X1 = prev;
            
            } 
            Y1= curr;   
        }
        // update previous
        prev = curr;
        // traverse right
        dfs(curr.right);
    }
}
