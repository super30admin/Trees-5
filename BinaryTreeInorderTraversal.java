import java.util.ArrayList;
import java.util.List;

//TC: Amortized O(n), Space: O(1)
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> output = new ArrayList<>();

        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) predecessor = predecessor.right;

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    output.add(current.val);
                    current = current.right;
                }
            } else {
                output.add(current.val);
                current = current.right;
            }
        }

        return output;
    }
}
