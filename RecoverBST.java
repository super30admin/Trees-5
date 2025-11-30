/**
 * LEetCode Problem: Recover Binary Search Tree
 * Url: https://leetcode.com/problems/recover-binary-search-tree/
 * Time Complexity: O(N)
 * Space Complexity: O(H) height of tree recursion stack
 */
public class RecoverBST {
    private TreeNode prevNode;
    private TreeNode firstNode;
    private TreeNode secondNode;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        swapNodes();
    }

    private void inOrder(TreeNode node) {
        if (node == null)
            return;

        inOrder(node.left);

        if (prevNode != null && prevNode.val > node.val) {
            if (firstNode == null) { // First breach
                firstNode = prevNode;
            }
            secondNode = node; // Second breach or adjacent nodes
        }
        prevNode = node;

        inOrder(node.right);
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

    public void swapNodes() {
        if (firstNode != null && secondNode != null) {
            int temp = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val = temp;
        }
    }

    public static void main(String[] args) {
        RecoverBST tree = new RecoverBST();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        tree.recoverTree(root);
        printInOrder(root);
    }

    private static void printInOrder(TreeNode node) {
        if (node == null)
            return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }
}
