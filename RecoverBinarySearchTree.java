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
 
// TC - O(n)
// SC - O(n)
 
// LC - 116
 
class Solution {
    public void recoverTree(TreeNode root) {
		// Sanity check
        if(root == null){
            return;
        }
        // Initializing stack
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode prev = null;
        TreeNode x = null;
        TreeNode y = null;
        // We are doing an inorder traversal, we store prev val and check with curr value, if prev val is greater than cur val, we found a pair which is not in BST format, we store it in x and y
		// We move forward and when we get another pair, we swap x and y
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            TreeNode top = stack.pop();
            
            if(prev != null && prev.val > top.val){
                y = top;
                if(x != null){
                    break;
                }
                x = prev;
            }
            
            prev = top;
            root = top.right;
        }
        swap(x, y);
    }
    
    private void swap(TreeNode x, TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}