// Time Complexity: O(n)
// Space complexity: O(h) due to recursive stack space
// Definition for a Node

public class PopulatePointersDFS {
    public Node connectDFS(Node root) {
        // Base case
        if (root == null) return null;

        // Start the DFS process
        dfs(root);

        return root;
    }

    private void dfs(Node root) {
        // Base case: If the root or its children are null, return
        if (root == null || root.left == null || root.right == null) return;

        // Connect the left child to the right child
        root.left.next = root.right;

        // If there's a next pointer, connect the right child to the next node's left child
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        // Recursively process left and right subtrees
        dfs(root.left);
        dfs(root.right);
    }

    // Main method to test the solution
    public static void main(String[] args) {
        PopulatePointersDFS solution = new PopulatePointersDFS();

        // Constructing a perfect binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Connect nodes using DFS
        solution.connectDFS(root);

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
