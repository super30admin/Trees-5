//https://leetcode.com/problems/recover-binary-search-tree/
/*
Time: O(n) where n is the number of nodes
Space: O(1) because of Morris InOrder traversal
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class RecoverBST {

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        TreeNode prev = null;
        TreeNode first = null, second = null;

        while (root != null) {
            if (root.left == null) {
                // *******actual recovery logic starts************
                if (prev != null && prev.val > root.val) {
                    if (first == null)
                        first = prev;

                    second = root;

                }
                prev = root;
                // *******actual recovery logic ends************

                root = root.right;
            }

            else {
                TreeNode temp = root.left;

                // Get to rightmost (inorder predecessor) of this left node
                while (temp.right != null && temp.right != root)
                    temp = temp.right;

                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                }

                else // we are pointing back to root (as we created a right link to root in prev
                     // step)
                {
                    temp.right = null; // remove the link that was created and print root

                    // *******actual recovery logic starts************
                    if (prev != null && prev.val > root.val) {
                        if (first == null)
                            first = prev;

                        second = root;

                    }
                    prev = root;
                    // *******actual recovery logic ends************

                    // means the left subtree is already visited, move on to right
                    root = root.right;
                }

            }
        }

        // write the swap logic
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

}
