import java.util.Stack;

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

public class RecoverBST {
    TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {

        iterativeInorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void iterativeInorder(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> st = new Stack<>();

        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (prev != null && prev.val >= root.val) {
                if (first == null) {
                    first = prev;
                    second = root;
                } else {
                    second = root;
                }
            }
            prev = root;
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        // Create an instance of RecoverBST
        RecoverBST recoverBST = new RecoverBST();

        // Recover the binary search tree
        recoverBST.recoverTree(root);

        // Print the values of the tree after recovering
        System.out.println("Values of the Recovered BST:");
        printInorder(root);
    }

    // Helper method to print the values of the tree in Inorder Traversal format
    private static void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }
}
