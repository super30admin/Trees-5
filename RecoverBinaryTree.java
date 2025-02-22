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

// TC: O(n) for traversing all the nodes.
// SC: O(h) for using the implicit recursion stack space
public class RecoverBinaryTree {
    static TreeNode first;
    static TreeNode second;
    static TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = null;
        root.left.left = null;
        root.left.right = new TreeNode(2);
        print(root);
        recoverTree(root);
        System.out.println();
        print(root);
    }

    private static void print(TreeNode root) {
        if (root == null)
            return;
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }

    public static void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (first == null && prev.val > root.val)
            first = prev;
        if (first != null && prev.val > root.val)
            second = root;
        prev = root;
        inorder(root.right);
    }
}