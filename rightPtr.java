// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        dfs(root);
        return root;
    }

    private void dfs(Node root) {
        if (root.left == null)
            return;

        root.left.next = root.right;

        if (root.next != null) {
            root.right.next = root.next.left;
        }

        dfs(root.left);
        dfs(root.right);

    }
}