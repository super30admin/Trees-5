import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
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
    }

    // BFS Solution
    // TC : O(n)
    // SC : O(h) // h is height of tree
    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            Node curr = que.poll();
            if (curr.left != null) {
                que.add(curr.left);
                que.add(curr.right);
            }
            for (int i = 1; i < size; i++) {
                Node temp = que.poll();
                curr.next = temp;
                curr = temp;
                if (curr.left != null) {
                    que.add(curr.left);
                }
                if (curr.right != null) {
                    que.add(curr.right);
                }
            }
        }
        return root;
    }

    //DFS solution
    // TC : O(n)
    // Sc : O(h) where h is height of tree
    public Node connect1(Node root) {
        if (root == null) return root;

        dfs(root.left, root.right);

        return root;
    }
    private void dfs(Node left, Node right){
        if (left == null) return;

        left.next = right;
        dfs(left.left, left.right);
        dfs(right.left, right.right);
        dfs(left.right, right.left);
    }
}
