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
	//Time Complexity:O(n)
	//Space Complexity:O(h) height of BT in stack
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
       dfs (root); 
       return res;
    }
    private void dfs (TreeNode node){
        if (node == null)
        return;

        dfs (node.left);
        res.add (node.val);
        dfs(node.right);
    }
}
