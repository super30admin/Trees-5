// Time Complexity : O(n)
// Space Complexity : O(n) - recursive stack 

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
    TreeNode second;
    TreeNode prev; // use this prev to compare the values if any discrepancy
    boolean flag ; // To identify if the adjacent nodes are swapped or not
    public void recoverTree(TreeNode root) {
        
        if (root == null){
            return;
        }
        
        // Inorder traversal and update the first and second nodes which dont hold BST property
        inorder(root);
        
        // Swap the node values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }
    
    
    private void inorder(TreeNode root){
        
        if (root == null){
            return;
        }
        
        // Left sub tree
        inorder(root.left);
        
        // Node
        // If any discrepancy found
        if (prev != null && prev.val > root.val ){
            
            // update and store the discrepancy
            if (flag == false) {
                // adjacent nodes swapped
                first = prev;
                second = root;
                flag = true;
            }
            else {
                // adjacent nodes not swapped.
                // only update the second 
                second = root;
            }
            
            
        }
        
        // for next recurse call
        prev = root;
        
        // Right sub tree
        inorder(root.right);
    }
}