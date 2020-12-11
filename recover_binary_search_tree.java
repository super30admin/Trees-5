// Time Complexity : O(n), where n is the size of the tree
// Space Complexity : O(h), where h is the height of the tree (recursive space stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain English
//1. Do inorder traversal, and once you reach the leaf of the left subtree, start checking if prev node is greater than equal to root
//2. Also take 2 more nodes, to store the 2 misplaced nodes. So if prev is greater than or equal to root AND if first is still
        // NULL, then assign prev to First (first misplaced node) and root as last Node (second misplaced node) --> This is only in
        //the case where the 2 misplaced nodes are consecutive or adjacent nodes
//3. Else prev is greater than or equal to root AND first is already found then just update your last node with root.
        //In the end just swap the values of first and last nodes

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
class Solution {
    TreeNode first;
    TreeNode last;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        //make prev as null
        prev = null;
        first = null;
        last = null;
        
        //call dfs on root
        dfs(root);
        //once the misplaced 2 nodes are found, reverse their values
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    
    public void dfs(TreeNode root){
        //base
        if(root == null) return;
        
        //logic
        //go to the left subtree till the leaf node
        dfs(root.left);
        //check is BST has a breach
        if(prev!=null && prev.val >= root.val){
            if(first == null){
                first = prev;
            }
            last = root;
        }
        //current root becomes prev
        prev = root;
        //proceed the root to the next node
        dfs(root.right);
    }
}