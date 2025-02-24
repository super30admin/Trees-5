
/**
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None
 */

public class RecoverBinaryTree {
    public class TreeNode {

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
    
    TreeNode first, second, prev;
    public void recoverTree(TreeNode root) {
        if (root == null) 
            return;

        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        //base
        if (root == null)
            return;
        
        //logic
        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null)
                first = prev;
            second = root;
        }

        prev = root;
    
        inorder(root.right);
        
    }
    public static void main(String[] args) {
        // Your code here
    }
}