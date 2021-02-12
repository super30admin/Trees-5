// Time Complexity : O(n)
// Space Complexity : O(height of tree) stack memory
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// find both tree and swap value

class Solution {
    TreeNode pre;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        dfs(root);
        int num = first.val;
        first.val = second.val;
        second.val = num;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(pre != null && pre.val > root.val){
            if(first==null) first = pre;
            second = root;
        }
        pre = root;
        dfs(root.right);
    }
}