//TC: O(n) — visit each node once.
//SC: O(h) — recursion stack (h = tree height); no extra data structures.

//In a perfect binary tree, for each non-leaf: set left.next = right.
//If curr.next exists, bridge subtrees with right.next = curr.next.left.
//Recurse on curr.left and curr.right; stop when curr.left == null (leaf).

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;

        dfs(root);
        return root;
    }

    private void dfs(Node curr){
        if(curr.left == null) return;

        curr.left.next = curr.right;
        if(curr.next != null){
            curr.right.next = curr.next.left;
        }

        dfs(curr.left);
        dfs(curr.right);
    }
}