// Time Complexity :O(H)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// TO reduce the stack space and time we do this morris inorder traversal
// iterative approach
// find the right most child of the left sub tree and connect it to the parent while traversing down
// the right child right pointer points to parent
// reverse it while moving up
import java.util.*;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {

            if (curr.left == null) {

                res.add(curr.val);
                curr = curr.right;

            } else {

                TreeNode pre = curr.left;

                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {

                    pre.right = curr;
                    curr = curr.left;

                } else {

                    pre.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return res;
    }
}