// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

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
//iterative
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        //null
        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root){
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val){
                if(first == null){
                    //first
                    first = prev;
                    second = root;
                } else{
                    second = root;
                }
            }
            prev = root;
            root = root.right;
        }
    }
}

/*
//recursive method
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode root;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        //null
        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root){
        //base
        if(root == null)return;
        //logic
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            //breach
            if(first == null){
                //first
                first = prev;
                second = root;
            } else{
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
*/