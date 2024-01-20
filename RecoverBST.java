//Time complexity : O(n)
//Space complexity : O(h)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class RecoverBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        recoverTree(root);
    }

    private static TreeNode first;
    private static TreeNode second;
    private static TreeNode prev;

    private static void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}