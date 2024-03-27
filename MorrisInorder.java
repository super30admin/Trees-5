// TC: O(nh)
// SC: O(1)

// Approach: Form connections with the current node with it's left's rightmost.
// This allows you to return to the current node at a later stage in inorder fashion.
// Do this for all nodes till you have no left node. Now, as you are at the left most node
// this is the smallest element, process it and do the same for the rest.

import java.util.ArrayList;
import java.util.List;

class MorrisInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode current = root;
        List<Integer> res = new ArrayList<Integer>();

        while (current != null) {
            // leaf nodes
            if (current.left == null) {
                res.add(current.val);
                current = current.right;
            } else {
                TreeNode prev = current.left;
                // either connection hasnt been formed yet or it has
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    res.add(current.val);
                    current = current.right;
                }
            }
        }

        return res;
    }
}