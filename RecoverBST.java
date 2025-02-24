/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class RecoverBST {

    TreeNode prev, first, second;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
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

    // Iterative approach
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode prev = null;
        TreeNode first = null, second = null;
        int count = 0;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev.val > root.val) {
                count++;
                if (first == null) {
                    first = prev;
                }
                second = root;
                if (count == 2) {
                    break;
                }
            }
            prev = root;
            root = root.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    class TreeNode {
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
}
