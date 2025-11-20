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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();

        while (root != null) {

            if (root.left == null) {
                result.add(root.val);
                root = root.right;
            } else {
                // find the right most element of root.left
                TreeNode curr = root.left; 

                while (curr.right != null && curr.right != root) {
                    curr = curr.right;
                }

                if (curr.right == null) {
                    curr.right = root;
                    root = root.left;
                } else {
                    curr.right = null;
                    result.add(root.val);
                    root = root.right;
                }
                
            }

        }

        return result;
    }
}
