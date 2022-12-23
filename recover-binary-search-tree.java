
//tc is O(n)
//sc is O(h)
import java.util.*;

class Solution {
    TreeNode prev, curr, first, second;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;

        dfs(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void dfs(TreeNode root) {

        // base
        if (root == null)
            return;

        // logic

        dfs(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }

            second = root;

        }

        prev = root;

        dfs(root.right);
    }

}