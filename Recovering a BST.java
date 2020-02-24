// Time complexity - 0(n)
//space complexity - 0(1) (Stack space - Height of the tree)
// Code successfully executed in leetcode

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode prev;
    TreeNode mid;
    TreeNode last;
    TreeNode first;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        dfs(root);
        if(first!=null && last!=null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if(first!=null && mid!=null){
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;    
        }
        

    }
    private void dfs(TreeNode root){
        //base case
        if(root == null) return;
        
        dfs(root.left);
        if(prev!=null && root.val < prev.val){
            if(first==null){
                mid = root;
                first =prev;
            }else {
                last = root;
            }
        }
        prev = root;
        dfs(root.right);
    }
}
    