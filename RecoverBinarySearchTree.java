//  Time Complexity: O(n)
//  Space Complexity: O(n) for recursive stack

public class RecoverBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode prev = null, first = null, second = null;

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);

            if (prev != null) {
                if (prev.val > root.val) {
                    if (first == null) {
                        first = prev;
                    }

                    if (first != null) {
                        second = root;
                    }
                }
            }
            prev = root;

            inOrder(root.right);
        }
    }

    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
