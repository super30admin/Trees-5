// Time Complexity : O(n)
// Space Complexity : O(1)
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
        Stack<TreeNode> st = new Stack<>();
        TreeNode x=null,y=null,prev = null;
        while(root!= null || !st.isEmpty())
        {
            
            // push all the left 
            while(root!=null)
            {
                st.push(root);
                root = root.left;
            }
            
            // process the element
            TreeNode top = st.pop();
            if(prev!=null && prev.val>top.val)
            {
                y = top;
                if (x == null) x = prev;
                else break;
            }
            prev = top;
            root= top.right;
            
        }
        
        int temp = x.val;
        x.val= y.val;
        y.val = temp;
    }
}