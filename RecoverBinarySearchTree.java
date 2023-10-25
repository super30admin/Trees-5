//TC will be O(n)
//SC will be O(h)
//Iterative call

import java.util.Stack;

//Definition for a binary tree node.
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

class RecoverBinarySearchTree {
    TreeNode prev, first, second;
    int cnt;
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode prev =null;
        TreeNode first = null;
        TreeNode second = null;
        Stack<TreeNode> s = new Stack<>();

        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev != null && prev.val> root.val){
                if(first == null){
                    first = prev;
                }
                second = root;
            }
            prev = root;
            root =  root.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }


    public static void main(String[] args) {
        // Create a sample binary search tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        // Create an instance of the Solution class
        RecoverBinarySearchTree solution = new RecoverBinarySearchTree();

        // Call the recoverTree method to fix the tree
        solution.recoverTree(root);

        // Print the fixed tree (in-order traversal)
        System.out.println("In-order traversal of the fixed tree:");
        inOrderTraversal(root);
    }

    // Helper method for in-order traversal
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }
}