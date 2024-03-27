import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class RightPointers {
    // BFS
    // TC: O(n)
    // SC: O(n)
    // Approach: Bfs and connect the prev node with the next at each level
    public Node connectBFS(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size != 0) {
                Node current = queue.poll();

                if (current.left != null) {
                    current.left.next = current.right;
                    queue.add(current.left);
                    queue.add(current.right);
                }

                if (current.next != null && current.next.left != null) {
                    current.right.next = current.next.left;
                }

                size--;
            }
        }

        return root;
    }

    // DFS
    // TC: O(n)
    // SC: O(h)
    // Use preorder traversal; make the connections and move to either left or right
    public Node connectDFS(Node root) {
        if (root == null || root.left == null) {
            return root;
        }

        root.left.next = root.right;

        if (root.next != null) {
            root.right.next = root.next.left;
        }

        connectDFS(root.right);
        connectDFS(root.left);

        return root;
    }
}