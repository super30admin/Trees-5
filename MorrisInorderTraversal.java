// Time Complexity : O(N) average O(N*H) - worst case
// Space Complexity : O(1)
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
 */
//Morris Inorder traversal
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                result.add(curr.val);
                curr = curr.right;
            }else {
                TreeNode pre = curr.left;

                while(pre.right != null && pre.right != curr){
                    pre = pre.right;
                }

                if(pre.right == null){
                    pre.right = curr;
                    curr = curr.left;
                }else {
                    result.add(curr.val);
                    curr = curr.right;
                    pre.right = null;
                }
            }
        }
        return result;
    }
}


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();

        while(!st.isEmpty() || root != null) {

            while(root != null) {
                st.push(root);

                root = root.left;
            }

            root = st.pop();
            result.add(root.val);
            root = root.right;
        }

        return result;
    }
}