import java.util.ArrayDeque;
import java.util.Queue;
/**
 * Leetcode Problem 117: Populating Next Right Pointers in Each Node II
 * Given a binary tree, populate each next pointer to point to its next right node.
 * Level Order traversal is used to connect nodes at the same level.
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * BFS
 */
class PopulateNextRight {
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.next = null;
        }
    }

    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node levelHead = q.poll();
            Node curr = levelHead;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                curr.next = q.poll();
                curr = curr.next;
            }
            curr = levelHead;
            while (curr != null) {
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
                curr = curr.next;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // generate test cases if needed
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        PopulateNextRight solution = new PopulateNextRight();
        solution.connect(root);
        printNextPointers(root);
    }

    private static void printNextPointers(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node curr = levelStart;
            levelStart = null;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                if (levelStart == null) {
                    if (curr.left != null) levelStart = curr.left;
                    else if (curr.right != null) levelStart = curr.right;
                }
                curr = curr.next;
            }
            System.out.println("null");
        }
    }
}