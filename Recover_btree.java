//Time Complexity: o(n)
//Space Complexity: o(1)
//Expln: perfrom inorder traversal over bstree if prev>root then it violates store first = prev and last = root.
//Whereas to find the second violation the prev> root but the root will be the violation after this swap the val, 
//to diff btw first and last use a flag as both will constitute to prev > root
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
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode last = null;
    boolean flag = false;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        helper(root);
        if(first != null && last != null)
        {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        return;
    }
    private void helper(TreeNode root)
    {
        if(root == null) return;
        
        helper(root.left);
        if(prev != null && prev.val > root.val)
        {
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
        helper(root.right);
        
    }
}