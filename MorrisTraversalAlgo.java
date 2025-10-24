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
* Applying Morris Traversal Algorithm:
   - It works on any traversal and any kind of binary tree
   - The idea is to link the left childs rightmost leafs null pointer to the root or depending on the problem. 
   - This idea can also be used for flattening a binary tree into a list
TC: O(n) -> iterate through all the nodes
SC: O(1) -> no additional space required
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            TreeNode pred = curr.left;
            if (curr.left != null) {
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                }
                else{
                    pred.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
            else{
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }
}