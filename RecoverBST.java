// Time Complexity : O(N) N - number of nodes
// Space Complexity : O(H) H - height of the tree
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
    public void recoverTree(TreeNode root) {
        TreeNode prev = null;
        TreeNode top = null;
        TreeNode x = null,y=null;
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            top = st.pop();
            if(prev!= null && prev.val > top.val){
                if(y == null) x = prev;
                y = top;
            }
            prev = top;
            root = top.right;
        }
        if(x != null && y != null){
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }
}
