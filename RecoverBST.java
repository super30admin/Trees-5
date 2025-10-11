import java.util.Stack;
//TC: O(n), SC: O(n)
//Approach: We need to traverse the BST inorder and check for the first breach where current.val <= prev.val, assign it to the first node
//Similarly, there will occur another breach as the problem specifies, we assign it to the second node
//swap the values of first and second nodes
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
