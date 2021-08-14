// Time Complexity : O(n), n = number of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        dfs(root.left, root.right);
        return root;
    }
    private void dfs(Node left, Node right) {
        //base case
        if(left == null)
            return;
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }
}