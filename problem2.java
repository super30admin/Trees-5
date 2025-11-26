// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
We are using the inorder approach here, because this is a BTS the next node in the traversal should we 
bigger then cur but if that is not the case we know that this is the breach
we take note of that using to TreeNode vars in the end we swap them

to compare the vals we also have a prev node in the global

*/
class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        // base
        if (root == null)
            return;

        // recurse
        inorder(root.left);
        // logic
        if (prev != null && root.val <= prev.val) {
            if (first == null) {
                // first breach
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }
        prev = root;

        inorder(root.right);
    }
}