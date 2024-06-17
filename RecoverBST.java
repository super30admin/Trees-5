// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
 *///DFS Approach
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void helper(TreeNode root) {
        if(root == null){
            return;
        }

        helper(root.left);
        if(prev != null && prev.val >= root.val ) {
            if(first == null){
                first = prev;
                second = root;
            }else{
                second = root;
            }
        }

        prev = root;
        helper(root.right);
    }
}

// BFS Approach
class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();

        while(!st.isEmpty() || root != null){
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val) {
                if(first == null){
                    first = prev;
                    second=root;
                }else{
                    second = root;
                }
            }
            prev = root;
            root = root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }
}