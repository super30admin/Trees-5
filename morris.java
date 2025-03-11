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

//  TC: O(n)
// SC: O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while(root!=null){
            if(root.left!=null){
                TreeNode prev = root.left;
                while(prev.right!=null && prev.right!=root){
                    prev =prev.right;
                }
                if(prev.right==null){
                    prev.right=root;
                    root=root.left;
                }
                else{
                    prev.right=null;
                    res.add(root.val);
                    root=root.right;
                }
            }else{
                res.add(root.val);
                root=root.right;
            }
        }
        return res;
    }
}