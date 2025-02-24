import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None
 *
 */
public class MorrisInorderTraversal {

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

    List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        // base
        if (root == null) {
            return;
        }

        // logic
        dfs(root.left);
        result.add(root.val);
        dfs(root.right);
    }

    public static void main(String[] args) {
        // Your code here
    }
}
