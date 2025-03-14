/*
 * TC: O(n)
 * SC: O(1)
 */
import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();
        while (curr != null) {
            if (curr.left == null) { // no left subtree
                result.add(curr.val); // add to result
                curr = curr.right; // move to next right node
            } else {  // has a left subtree
                TreeNode ptr = curr.left;
                // Find the rightmost node in the left subtree, or the node that already points to curr
                while (ptr.right != null && ptr.right != curr) ptr = ptr.right;
                if (ptr.right == null) {
                    // Establish a temporary thread back to the current node
                    ptr.right = curr;
                    curr = curr.left;
                } else {
                    // The thread already exists, which means we've returned to curr after visiting left subtree
                    ptr.right = null; // restore
                    result.add(curr.val); // add curr to result
                    curr = curr.right; // move to right subtree
                }
            }
        }
        return result;
    }
}
