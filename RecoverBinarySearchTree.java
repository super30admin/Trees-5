//Time Complexity: O(n)
//Space Complexity: O(h) height of binary tree

/*
 * we traverse through the tree and keep track of previous element
 * if it is not less than or equal to next then we mark it and go
 * to the next element. same way we find the other and replace them.
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
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode root){
        //base
        if(root == null) return;

        //logic
        inorder(root.left);
        if(prev != null && root.val <= prev.val){
            if(first == null){
                first = root;
                second = prev;
            }
            else{
                first = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}