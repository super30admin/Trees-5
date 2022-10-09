import java.util.Queue;

/*
## Problem 2: Recover Binary Search Tree
(https://leetcode.com/problems/recover-binary-search-tree/)

Time Complexity :   O (n) 
Space Complexity :  O (n) 
Did this code successfully run on Leetcode :    Yes (99. Recover Binary Search Tree)
Any problem you faced while coding this :       No
 */
// Input: root = [1,3,null,null,2]
// Output: [3,1,null,null,2]
    
// Inorder Traversal of a BST gives a sorted list of elements.
class RecoverTree {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        
        inorder(root);
        
        // swap the values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root){
        // base
        if(root == null)
            return;
        
        // logic
        inorder(root.left);
        if(prev != null && prev.val > root.val){
             // first breach
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}