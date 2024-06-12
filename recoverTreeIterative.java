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
// Time: O(n) checking all the nodes for violations
// Space: O(h) max height of tree
// Idea here is to traverse all the nodes in an inorder manner to identify violations.
// Assigning prev to first violation and second to root provides liberty to swap the 2 values
// if we did not find any other violation. In case traversing ahead in inorder we found next violation.
// we can swap those 2 values
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public void inorder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root!=null || !st.isEmpty()) {
            while(root!=null) {
                st.push(root);
                root=root.left;
            }
            root = st.pop();
            if(prev!=null && prev.val>=root.val) {
                if(!flag) {
                    first = prev;
                    second = root;
                    flag = true;
                } else {
                    second = root;
                }
            }
            prev = root;
            root = root.right;
        }
    }
}