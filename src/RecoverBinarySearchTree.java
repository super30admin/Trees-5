// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 * 
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
    TreeNode first, second; //breach points
    boolean firstBreachSeen;
    
    
    //O(n) time, O(h) space dfs solution using inorder traversal to find breach points
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        
        findBreachPoint(root);
        
        //swap values from breach points
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void findBreachPoint(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode prev = null;
        while(root!= null || !stack.isEmpty()) {
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            TreeNode temp = stack.pop();
            
            if(prev != null && prev.val > temp.val) {//breach found
                if(!firstBreachSeen){//first breach point
                    firstBreachSeen = true;
                    first = prev;
                    second = temp;
                }else { //second breach
                    //if second breach exists, current node as second breach point
                    second = temp;
                    return;
                }
            }
            prev = temp;
            
            if(temp.right != null) {
               root = temp.right; 
            }  
        }
    }
}