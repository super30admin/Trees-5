// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach - DFS
class Solution {
    TreeNode first=null, second=null, prev=null;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        dfs(root);
        first.val = first.val+second.val;
        second.val = first.val-second.val;
        first.val = first.val-second.val;
    }
    public void dfs(TreeNode root){
        if(root==null) return;

        dfs(root.left);
        if(prev==null){
            prev = root;
        }
        else{
            if(prev.val > root.val){
                if(first == null){
                    first = prev;
                    second = root;
                }
                else second = root;
            }
            else{
                prev = root;
            }
        }
        dfs(root.right);
    }
}