// Time Complexity : O(N),N = #nodes
// Space Complexity : O(H) H = height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class RecoverBinarySearchTree {
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
        TreeNode first; //first  breach
        TreeNode second; //second breach
        TreeNode prev;
        boolean flag; // mark truefor first breach

        public void recoverTree(TreeNode root) {
            inorder(root);
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        private void inorder(TreeNode root) {
            //base
            if(root == null) return;

            //logic
            inorder(root.left);
            if(prev!=null && prev.val >= root.val) {
                if(flag) {
                    //second breach
                    second = root;
                } else {
                    first = prev;
                    second = root;
                    flag = true;
                }
            }
            prev = root;
            inorder(root.right);
        }
    }
}
