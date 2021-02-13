// Time Complexity : The time complexity is O(n) where n is the number of tree nodes
// Space Complexity : The space complexity if O(n) where n is the number of tree nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    boolean flag;

    public void recoverTree(TreeNode root) {

        dfs(root);

        //swap the nodes
        int temp = first.val;
        first.val = last.val;
        last.val = temp;

    }

    // Inorder traversal
    public void dfs(TreeNode root){

        if(root == null){
            return;
        }

        dfs(root.left);

        // check the prev node to have a BST
        if(prev != null && prev.val >= root.val){
            if(!flag){
                first = prev;
                last = root;
                flag = true;
            }
            else{
                last = root;
            }
        }
        prev = root;

        dfs(root.right);

    }
}