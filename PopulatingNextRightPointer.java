public class PopulatingNextRightPointer {
    public Node connect(Node root) {
        // return connectWithoutSpace(root);
        // return connectBFS(root);
//        return connectDFS(root);
    }

    // TC: O(N) where N is number of nodes in tree
    // SC: O(1)
    private Node connectWithoutSpace(Node root) {
        if (root == null) return null;
        Node level = root;
        while (level.left != null) {
            Node curr = level;
            while (curr != null) {
                curr.left.next = curr.right;
                curr.right.next = curr.next == null ? null : curr.next.left;
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }

    // TC: O(N) where N is number of nodes in tree
    // SC: O(D) where D is maximum diameter of tree
    private Node connectBFS(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node right = null;
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                curr.next = right;
                right = curr;

                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
            }
        }
        return root;
    }

    // TC: O(N) where N is number of nodes in tree
    // SC: O(H) where H is height of tree
    private Node connectDFS(Node root) {
        helper(root);
        return root;
    }

    private void helper(Node root) {
        if (root == null || root.left == null) return;
        root.left.next = root.right;
        root.right.next = root.next == null ? null : root.next.left;
        helper(root.left);
        helper(root.right);
    }
}
