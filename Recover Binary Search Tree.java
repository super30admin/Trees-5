// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
    //create the first last and prev pointers
    TreeNode first;
    TreeNode last;
    TreeNode prev;
    //and the flag
    boolean f;
    public void recoverTree(TreeNode root) {
        //edge
        if(root == null) return;
        //call recurison
        inorder(root);
        //now that we have both poitners swap them using a temp
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    
    private void inorder(TreeNode root){
        //base
        //if root is leaf node
        if(root == null) return;
        //logic
        //call recurison on left
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            //check the first breach that means flag is still false
            if(!f){
                //make first equal to prev
                first = prev;
                //last equal to current
                last = root;
                //change flag to true because first breach
                f = true;
            }
            //second breach
            else
            {
                //just change last to current
               last = root;
            }   
        }
        //move prev to current
        prev = root;
        //call recursion on right
        inorder(root.right);
    }
}