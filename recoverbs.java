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
 //TC-O(N),SC-O(h)
 class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        // find the nodes of breaches by validating the BST and swap the nodes, perform inorder traversal 
        inorder(root); 
        int temp=first.val;
        first.val =second.val;
        second.val = temp;
        System.out.println(first.val);System.out.println(second.val);
        
    }
    public void inorder(TreeNode root){
        //basecase
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && prev.val > root.val){
            if(first==null){
                first = prev;
                second = root;
            }
            else{
               second=root;
            }
        }
            prev=root;
            inorder(root.right);
        }
    }
