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
class recoverBinarySearchTree {
    TreeNode first, second, prev;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        
        inorder(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}

//time complexity O(n)
//space complexity O(h)