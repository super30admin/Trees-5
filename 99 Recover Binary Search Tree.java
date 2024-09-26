//99. Recover Binary Search Tree
//TIME COMPLEXITY:O(n)
//Space Complexity:O(1)
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
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        helper(root);
      
        int firstVal = first.val;
        int secondVal = second.val;
        first.val = secondVal;
        second.val = firstVal;
       
    }
    public void helper(TreeNode root){
        //IN-order traversal
        
        //LNR
        if(root == null)
            return;
        
        helper(root.left);
        //Process current node
        //Match with prev node 
        //if first mark it
        if(prev != null&& first== null && prev.val > root.val){
            first = prev;
            second = root;
        }
        if(first!= null)
        {
            //tracking min nodes
            if( second != null && root.val < second.val){
                second = root;
            }
        }
        prev = root;
        helper(root.right);
        
        
    }
}
