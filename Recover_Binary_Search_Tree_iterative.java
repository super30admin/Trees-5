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
// TC : O(n)
// SC : O(h)
// Method - 1 iteration
class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        
        Stack<TreeNode> st = new Stack<>();
        TreeNode first = null, second = null;
        TreeNode prev = null;
        while(root != null || !st.isEmpty()) {
            
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val) {
                if(first == null ) {
                     first = prev;
                     second = root;
                }
                    second = root;
            }
            prev = root;
            root = root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
