/**
 * Url: 
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * Time Complexity: O(N)
 * Space Complexity: O(H) height of tree recursion stack
 * DFS
 */
public class PopulateNextRight2 {
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
        dfs(root);
        return root;
    }

    private void dfs(Node root) {
        if (root == null)
            return;

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        dfs(root.left);
        dfs(root.right);

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
        PopulateNextRight2 solution = new PopulateNextRight2();
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
                    if (curr.left != null)
                        levelStart = curr.left;
                    else if (curr.right != null)
                        levelStart = curr.right;
                }
                curr = curr.next;
            }
            System.out.println("null");
        }
    }
}
