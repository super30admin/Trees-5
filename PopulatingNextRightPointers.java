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
}

public class PopulatingNextRightPointers {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        connectWithAuxilliarySpace(root);

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        connectWithoutAuxilliarySpace(root1);
    }

    // TC: O(n) as all the nodes are being traversed
    // SC: O(n) where q contributes to the space complexity
    public static Node connectWithAuxilliarySpace(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                Node current = q.poll();
                if (i < level - 1)
                    current.next = q.peek();
                if (current.left != null)
                    q.offer(current.left);
                if (current.right != null)
                    q.offer(current.right);
            }
        }
        return root;
    }

    // TC: O(n) as all the nodes are being traversed
    // SC: O(1) no auxilliary space is used
    public static Node connectWithoutAuxilliarySpace(Node root) {
        if (root == null)
            return null;
        Node head = root;
        while (head != null) {
            Node dummy = head;
            Node temp = dummy;
            while (head != null) {
                if (head.left != null) {
                    temp.next = head.left;
                    temp = temp.next;
                }
                if (head.right != null) {
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }
        return root;
    }
}
