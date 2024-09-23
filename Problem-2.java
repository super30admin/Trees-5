// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.


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
    TreeNode second;
    TreeNode prev;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            System.out.println(root.val);

            if(prev != null && root.val < prev.val){
                if(first == null){
                    first = prev;
                    second = root;
                }else{
                    second = root;
                    break;
                }
            }
            prev = root;
            root = root.right;
        }
    }
}