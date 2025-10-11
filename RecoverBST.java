import java.util.Stack;
//TC: O(n), SC: O(n)
public class RecoverBST {

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        TreeNode first = null, second = null, prev = null;
        TreeNode current = root;

        final Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if (prev != null && current.val <= prev.val) {
                if (first == null) first = prev;
                second = current;
            }

            prev = current;
            current = current.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
