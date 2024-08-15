import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

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

public class PopulatingNextRightPointer { //O(n) T.C, O(n) S.C
    public static Node connectBFS(Node root) {
        if(root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                Node current = q.poll();
                if(i != size-1) { //until last node in current level
                    assert current != null;
                    current.next = q.peek(); //point current's next to the top in queue
                }
                assert current != null;
                if(current.left != null) { //and add the current's left and right children to q
                    q.add(current.left);
                    q.add(current.right);
                }
            }
        }
        return root;
    }

    public static Node connectDFS(Node root) { //O(n) T.C, O(h) S.C
        if(root == null) return null;
        dfs(root);
        return root;
    }

    private static void dfs(Node root) {
        if(root.left == null) return;

        root.left.next = root.right; //point root.left's next to root.right

        if(root.next != null) { //if root has a right node in the same level
            root.right.next = root.next.left; //point root.right's next to root.next's left
        }

        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        // Creating a perfect binary tree:
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node root2 = root;

        // Populating next right pointers
        root = connectBFS(root);
        root2 = connectDFS(root2);

        // Printing the next pointers for each level
        printNextPointers(root);
        System.out.println();
        printNextPointers(root2);
    }

    // Helper method to print the next pointers at each level
    private static void printNextPointers(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node current = levelStart;
            while (current != null) {
                System.out.print(current.val + " -> " + (current.next != null ? current.next.val : "null") + "  ");
                current = current.next;
            }
            System.out.println();
            levelStart = levelStart.left; // Move to the next level
        }
    }
}