// Time Complexity : O(n) 
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach:
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
    List<TreeNode> path;
    public void recoverTree(TreeNode root) {
        if(root== null)
            return;
        TreeNode first=null;
        TreeNode second=null;
        path = new ArrayList<TreeNode>();
        helper(root);
        for(int i=0;i<path.size()-1;i++){
            //System.out.println(path.get(i).val);
            if(path.get(i).val>path.get(i+1).val){
                if(first==null){
                    first=path.get(i);
                    second=path.get(i+1);
                }
                else{
                    second=path.get(i+1);
                    break;
                }                
            }                         
        }
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    private void helper(TreeNode root){
        if(root==null)
            return;
        helper(root.left);
        path.add(root);
        helper(root.right);
    }
}