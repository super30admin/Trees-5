// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : Amortized O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using Morris' algorithm for creating temporary reference from node's left's right subtree to point back to the node for doing the in order traversal.
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            // if there is a left node, we go to
            if (curr.left != null) {
                TreeNode pre = curr.left;
                // going downward direction, we have to go till the pre.right != null so we can point that node to curr
                // going upward direction, we have to go till pre.right != curr since we have to remove the reference to that node
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                //downward motion
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                }
                // upwards motion
                else {
                    // remove the temporary reference that we added
                    pre.right = null;
                    // add the current to the result
                    result.add(curr.val);
                    curr = curr.right;
                }

            } else {
                // if there is no left, we add the current value to result go to right for inorder
                result.add(curr.val);
                curr = curr.right;
            }
        }

        return result;
    }
}