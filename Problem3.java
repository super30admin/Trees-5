// 94. Binary Tree Inorder Traversal

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

 /*
Iteratively while going down we find predecessor for the nodes and point predessesor to their ancesor and while going up we remove the links to the ancestor and process the node.
TC: O(n) SC: O(1)
 */
class Solution {

    private List<Integer> result;
    
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        result = new ArrayList<>();
        while(curr != null){
            if(curr.left == null){ // leaf node or no left subtree
                // vist and move to right
                result.add(curr.val); 
                curr = curr.right;
            } else {
                // Find predecessor - smallest right most element on left subtree
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }

                if(pred.right == null){ // We have found pred create link with curr
                    pred.right = curr;
                    curr = curr.left;
                }else if(pred.right == curr) { // We are visiting the node second time
                    pred.right = null; // Remove the link
                    result.add(curr.val); // Visit the node since the left subtree is done
                    curr = curr.right; // Move to right
                }
            }
        }

        return result;
    }
}