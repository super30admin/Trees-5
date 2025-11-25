/*
 Algorithm: Recursive DFS connections for perfect binary tree

 Approach:
 - For each node, connect node.left.next = node.right.
 - If node.next is not null, connect node.right.next = node.next.left to bridge between sibling subtrees.
 - Recurse on left and right children.
 - Works for perfect binary trees where every parent has two children.

 Time Complexity: O(n) where n is number of nodes (each node visited once).
 Space Complexity: O(h) recursion stack where h is tree height (log n for perfect tree).

 LeetCode: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/ (116)
*/

public class PopulatingNextRightPointersInEachNode3 {

    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    private void dfs(Node root){
        //base
        if(root.left == null) return;

        //logic
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
