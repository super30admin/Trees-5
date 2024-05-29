// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach - DFS
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }
    public void dfs(TreeNode root){
        if(root==null) return;

        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}