/*
 * TC: O (n)
 * SC: O (h)
 */
public class RecoverBST {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

    TreeNode first, second, prev, curr;

    //find first and second anomalies during inorder traversal
    void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        curr = node;
        if (prev != null && curr.val < prev.val) {
            second = curr;
            // first swap occurrence (first is set)
            if (first == null) first = prev;
            // second swap occurrence (second is set)
            else return;
        }
        prev = curr;

        inorder(node.right);
    }

    void swap(TreeNode first, TreeNode second) {
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void recoverTree(TreeNode root) {
        inorder(root);
        //swap first and second to recover Tree
        swap(first, second);
    }
}
