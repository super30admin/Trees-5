import java.util.List;
/**
 * Morris Inorder Traversal of a binary tree.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MorrisInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new java.util.ArrayList<>();

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode predecessor = curr.left; // travel to left
                TreeNode right = predecessor.right; // travel to the last right
                while (right != null && right != curr) { // till we find the last right and not pointing to current. to
                                                         // avoid cycle
                    predecessor = right;
                    right = right.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = curr; // connect last right to current
                    curr = curr.left;
                } else {
                    predecessor.right = null; // restore the tree
                    result.add(curr.val); // visit current
                    curr = curr.right;
                }

            } else {
                result.add(curr.val); // visit current
                curr = curr.right;
            }

        }
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        MorrisInorderTraversal traversal = new MorrisInorderTraversal();
        List<Integer> result = traversal.inorderTraversal(root);
        System.out.println(result); // Output: [1, 3, 2]

        // another example
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        List<Integer> result2 = traversal.inorderTraversal(root2);
        System.out.println(result2); // Output: [1, 2, 3, 4, 5]
    }
}
