// Time Complexity : O(n), visit all nodes
// Space Complexity : O(h), height of tree - stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Perform inorder traversal of the BST (iterative in this case).
//   - Track the previously visited node (`prev`).
//   - If `prev.val >= current.val`, a violation of BST property is detected.
//   - Record the first and second misplaced nodes (`first` and `second`).
//   - After traversal, swap the values of these two nodes to restore the BST.


import java.util.Stack;

class TreeNode {
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

public class RecoverBinarySearchTree {
    TreeNode prev; //to find breach
    TreeNode first, second; //swapping during breach
    void recoverTree(TreeNode root) {

        // helper(root);
        // int temp = first.val;
        // first.val = second.val;
        // second.val = temp;

        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();

            if(prev != null && prev.val >= root.val) {
                if(first == null) {
                    first = prev;
                    second = root;
                } else {
                    second = root;
                }
            }

            prev = root;
            root = root.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root) {
        if(root == null) {
            return;
        }

        helper(root.left);

        if(prev != null && prev.val >= root.val) {
            if(first == null) { //first time breach
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }

        prev = root;

        helper(root.right);
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree obj = new RecoverBinarySearchTree();

        // Construct the BST with swapped nodes
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2); // Swapped with root (3 <-> 2)

        System.out.println("Before recovery (inorder traversal):");
        inorderPrint(root);

        obj.recoverTree(root);

        System.out.println("\nAfter recovery (inorder traversal):");
        inorderPrint(root);
    }

    private static void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }
}
