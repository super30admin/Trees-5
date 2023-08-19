// Time Complexity : O(n) -> number of nodes
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

public class PopulateNextRightPointerInEachNodeUsingDFSWithTwoNodes {

    public Node connect(Node root) {

        if(root == null) return null;
        dfs(root.left, root.right);
        return root;
    }

    public void dfs(Node left, Node right)
    {
        if(left == null) return;
        left.next = right;
        dfs(left.left,left.right);
        dfs(right.left,right.right);
        dfs(left.right,right.left);
    }
}
