// Time Complexity : O(n) because each node is visited at most twice
// Space Complexity : O(1) excluding the output list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use Morris Inorder Traversal to perform inorder traversal without recursion or a stack.
// For each node with a left subtree, we create a temporary thread from its inorder predecessor back to the current node.
// Once the left subtree is processed, we remove the thread, visit the node, and continue to the right subtree.

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();

        while(curr != null) {

            // no left subtree, visit node directly
            if(curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {

                // find inorder predecessor
                TreeNode pre = curr.left;
                while(pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                // create thread and go left
                if(pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {

                    // remove thread and visit node
                    pre.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return result;
    }
}