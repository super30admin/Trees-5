// Time Complexity : O(n)
// Space complexity : O(h) due to recursive stack space
public class PopulatePointersSymmetricTreeApproach {
    public Node connectDFSSymmetric(Node root) {
        // Base case
        if (root == null) return null;

        // Start the DFS process
        dfs(root.left, root.right);

        return root;
    }

    private void dfs(Node left, Node right){

        // if either of the nodes is null stop recurrsion
        if(left == null || right == null) return;

        // connect the left child to the right child
        left.next = right;

        // recursively connect the subtrees in mirrored fashion

        dfs(left.left, left.right); // connect left subtree internally
        dfs(left.right, right.left); // connect across subtrees
        dfs(right.left, right.right); // connect the right subtree internally
    }

    public static void main(String[] args) {
        PopulatePointersSymmetricTreeApproach solution = new PopulatePointersSymmetricTreeApproach();

        // Constructing a perfect binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Connect nodes using the symmetric tree approach
        solution.connectDFSSymmetric(root);

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

