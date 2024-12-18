// Time Complexity O(n)
// Space Complexity O(h) due to recursive stack space
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
        TreeNode (int val)
        {this.val = val;}
        TreeNode (int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

public class RecoverBST {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root){
        helper(root);

        // swap nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        // In-order traversal
        helper(root.left);
        // Process the current node
        if (prev != null && prev.val >= root.val) {
            if (first == null) {
                first = prev;
            }
            // always update the second node
            second = root;
        }
        prev = root; // update the previous node to the current node

        // traverse the right subtree
        helper(root.right);
    }

    public static void main (String[] args){
        RecoverBST solution = new RecoverBST();

        // Create a binary search tree with swapped nodes
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        System.out.println("Before recovery (in-order traversal):");
        printInOrder(root);

        // Recover the BST
        solution.recoverTree(root);

        System.out.println("\nAfter recovery (in-order traversal):");
        printInOrder(root);
    }

    // Utility method to print the tree in in-order traversal
    public static void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
}
