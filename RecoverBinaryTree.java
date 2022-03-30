// Time Complexity : O(n)  For traversal
// Space Complexity : O(n) For recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Inorder traversal should give us the nodes in sorted order
// When we see an anamoly we know the element is swapped
// For 1st anamoly prev of cur is wrongly placed and for second anamoly the current is wrongly placed
// We can observe this by simple intuition.
// We case where adjacent elements are swapped we won't find any second anamoly
// Cosidering the above cases we will find them in inorder traversal and swap them.

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
    TreeNode a,b,prev;
    public void recoverTree(TreeNode root) {
        a = null;
        b = null;
        prev = null;
        inorder(root);
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
        
    }
    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        if(prev != null && root.val < prev.val){
            if(a == null){
                a = prev;
                b = root;
            }
            else{
                b = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}