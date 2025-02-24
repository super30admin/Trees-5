
/**
 * Time Complexity: O(N)
 * Space Complexity: O(N) using BFS/DFS approach, O(1) using Optimal
 */

import java.util.Queue;

public class PopulateRightPointersofBST {

    // Using BFS
    public Node connectUsingBFS(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (i != size - 1) {
                    current.next = queue.peek();
                }
                if (current.left != null) {
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }
        }
        return root;
    }

    // Using DFS
    public Node connectUsingDFS(Node root) {
        if (root == null) {
            return root;
        }
        dfs(root.left, root.right);
        return root;
    }

    private void dfs(Node left, Node right) {
        if (left == null) {
            return;
        }
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }

    // Optimal
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node left = root;
        while (left.left != null) {
            Node current = left;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            left = left.left;
        }
        return root;
    }

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
}
