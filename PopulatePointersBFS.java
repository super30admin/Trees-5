// Time Complexity : O(n)
// Space Complexity : O(1)
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
}

    public class PopulatePointersBFS {
        public Node connect(Node root) {
            // base case
            if (root == null) return null;

            // start with leftmost Node
            Node level = root;

            while (level.left != null) {
                Node curr = level;
                while (curr != null) {
                    // connect the left child to the right child of the same parent
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

        public static void main(String[] args) {
            PopulatePointersBFS solution = new PopulatePointersBFS();

            // Constructing a perfect binary tree
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);

            // Connect nodes at the same level
            solution.connect(root);

            // Print the next pointers of each level
            printNextPointers(root);
        }

        // Utility method to print the next pointers for each level
        public static void printNextPointers(Node root) {
            Node level = root;

            while (level != null) {
                Node curr = level;
                while (curr != null) {
                    System.out.print(curr.val + " -> ");
                    if (curr.next != null) {
                        System.out.print(curr.next.val + " ");
                    } else {
                        System.out.print("null ");
                    }
                    curr = curr.next;
                }
                System.out.println();
                level = level.left;
            }
        }
    }
