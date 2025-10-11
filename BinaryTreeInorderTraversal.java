import java.util.ArrayList;
import java.util.List;

//TC: Amortized O(n), Space: O(1)
//Approach: Morris Inorder Traversal without using recursive or iterative stack
//The idea is to have the Binary tree printed in inorder fashion but without using a stack
//that means to point the right of the predecessor to the current node going downwards from the root
//while coming back up if the predecessor's right = current, detach it
//if current.left == null or predecessor.right == current, put the element in the output and move the current node
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
