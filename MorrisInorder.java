//Time complexity:- O(n)
//Space complexity:- O(1)
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
        
        //Morris Traversal
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;

        //If there is no left child -> add root val to result
        //If there is left child. Go to rightmost node of left subtree and add the root node to its right
        while(curr != null) {

            //check if there is left subtree
            if(curr.left == null) {

                result.add(curr.val);
                curr = curr.right;
            }
            //find the rightmost node in right subtree
            else {

                TreeNode pre = curr.left;
                while(pre.right != null) {

                    pre = pre.right;
                }

                //once we find rightmost node, add curr root to its right
                pre.right = curr;
                TreeNode tmp = curr;
                curr = curr.left;
                tmp.left = null;
            }
        }

        return result;
    }
}