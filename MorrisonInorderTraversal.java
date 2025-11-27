// Time Complexity : O(n).
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We implement Morrision Inorder Traversal which is without using stack or recursion.First we move downwards towards the left. We update predeccesor pre
// to the right most node in the left subtree to make a connection with the root. We make these connections while parsing downwards, and while coming upwards
// we remove those connections and add to the result.

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode pre = curr.left; // moving downwards
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right; //right most node on the current tree to make a connection
                }
                if (pre.right == null) { // connecting the tree node to curr while moving downwards
                    pre.right = curr;
                    curr = curr.left;
                } else { // removing the connection while parsing upwards
                    pre.right = null;
                    result.add(curr.val);
                    curr = curr.right; //remove the connection
                }
            } else {
                result.add(curr.val);
                curr = curr.right;
            }
        }
        return result;
    }
}

