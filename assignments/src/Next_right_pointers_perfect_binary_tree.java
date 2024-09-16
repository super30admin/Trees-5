// Approach: We do Level order traversal (BFS) Iterative solution and make connections as required while traversing
// the tree.
// Time: O(n)
// Space: O(1)
class Next_right_pointers_perfect_binary_tree {
    public Node connect(Node root) {
        if (root == null) return null;

        Node level = root;
        while (level.left != null) {
            Node curr = level;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}