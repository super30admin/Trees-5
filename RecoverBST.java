package Dec7;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class RecoverBST {
    
    /*
    Time complexity: O(n) where n is no.of elements in BST
    
    Space complexity: O(h) where h is height of tree    
    
    Approach: Inorder traversal performed on given BST to find breach node values while traversing itself. Breach node values swapped later.
    */
    
    TreeNode first, last, prev;
    
    public void recoverTree(TreeNode root) {
        // edge
        if (root == null) {
            return;
        }
        inorder(root);
        // swap breach elements
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    
    // recursive function for inorder traversal and finding breach elements
    public void inorder(TreeNode root) {
        // base
        if (root == null) {
            return;
        }
        
        // logic
        inorder(root.left);
        // st.pop();
        if (prev != null && prev.val >= root.val) {
            // breach found: mark first and last elements
            if (first == null) {
                // first breach: mark both first & last element.
                first = prev;
                last = root;
            } else {
                // second breach: mark only last element.
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}