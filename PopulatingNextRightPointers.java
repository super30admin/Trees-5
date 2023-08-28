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

public class PopulatingNextRightPointers {
    public Node connect(Node root) {
        if (root == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (i != size - 1) {
                    curr.next = q.peek();
                }
                if (curr.left != null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // Create the tree (Example: Perfect Binary Tree)
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Create an instance of PopulatingNextRightPointers
        PopulatingNextRightPointers populatingNextRightPointers = new PopulatingNextRightPointers();

        // Connect the next pointers in the tree
        Node rootWithNextPointers = populatingNextRightPointers.connect(root);

        // Print the values and next pointers of the tree (in Level Order Traversal
        // format)
        System.out.println("Values and Next Pointers of the Tree:");
        printTreeWithNextPointers(rootWithNextPointers);
    }

    // Helper method to print the values and next pointers of the tree in Level
    // Order Traversal format
    private static void printTreeWithNextPointers(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                System.out.print(node.val + " -> ");
                if (node.next != null) {
                    System.out.print(node.next.val + ", ");
                } else {
                    System.out.print("null, ");
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }
}