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
// Time Complexity : O(n)
// Space Complexity : O(1)
// Method used : Morris Inorder Traversal

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        TreeNode curr = root, prev;
        List<Integer> result = new ArrayList();

        while(curr != null)
        {
            if(curr.left == null)
            {
                result.add(curr.val);
                curr = curr.right;
            }
            else
            {
                prev = curr.left;

                while(prev.right != null && prev.right != curr)
                {
                    prev = prev.right;
                }

                if(prev.right == null)
                {
                    prev.right = curr;
                    curr= curr.left;
                }
                else
                {
                    prev.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return result;
    }
}
