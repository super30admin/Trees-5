// Time Complexity : O(n) -> number of nodes
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

public class PopulateNextRightPointerInEachNodeUsingDFS {
    public Node connect(Node root) {
        if(root == null) return null;
        dfs(root);
        return root;
  }

    public void dfs(Node curr)
    {
        if(curr.left == null) return;
        curr.left.next = curr.right;
        if(curr.next!=null)
        {
            curr.right.next = curr.next.left;
        }
        dfs(curr.left);
        dfs(curr.right);

    }
}
