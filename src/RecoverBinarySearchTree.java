// Time Complexity:  O(n)
// Space Complexity: O(n)
// where n is number of nodes in tree

/**
 * Definition for a binary tree node.
 * */
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

    TreeNode a, b, prev;

    public void recoverTree(TreeNode root) {
        a = b = prev = null;
        inorder(root);
        int temp = a.val;                           // swapping values
        a.val = b.val;
        b.val = temp;
    }

    private void inorder(TreeNode node) {

        if(node == null)
            return;

        inorder(node.left);

        if(prev != null) {
            if(prev.val > node.val) {               // if this node is swapped one
                b = node;
                if(a == null) {                     // and this pair is the first swapped one
                    a = prev;
                }
            }
        }
        prev = node;

        inorder(node.right);

    }
}