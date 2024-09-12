// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

public class RecoverBinarySearchTree {

    /**
     * Definition for a binary tree node.
     **/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;

        public void recoverTree(TreeNode root) {
            if (root == null) return;

            while (root != null) {
                if (root.left == null) {
                    //move to right node
                    if (prev != null && prev.val > root.val) {
                        if (first == null) {
                            first = prev;
                        }
                        second = root;
                    }
                    prev = root;
                    root = root.right;
                } else {
                    //go to far right
                    TreeNode temp = root.left;
                    while (temp.right != null && temp.right != root) {
                        temp = temp.right;
                    }
                    if (temp.right == null) {
                        temp.right = root;
                        root = root.left;
                    } else {
                        temp.right = null;
                        //print root
                        if (prev != null && prev.val > root.val) {
                            if (first == null) {
                                first = prev;
                            }
                            second = root;
                        }
                        prev=root;
                        root = root.right;
                    }
                }
            }
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}