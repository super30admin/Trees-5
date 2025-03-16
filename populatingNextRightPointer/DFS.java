package populatingNextRightPointer;

//tc: O(n), where n is the no of nodes in the tree
//sc: O(logN)

class DFS {
    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        dfs(root);

        return root;
    }

    private void dfs(Node root) {

        if(root.left == null) {
            return;
        }

        root.left.next = root.right;

        if(root.next != null) {
            root.right.next = root.next.left;
        }

        dfs(root.left);
        dfs(root.right);
    }
}