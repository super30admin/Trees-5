import java.util.LinkedList;
import java.util.Queue;

// Definition for a Node.
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

public class NextRightPointer {

    // TC : O(n)
    // SC : O(1)
    public Node connect(Node root) {
        if(root == null) return null;

        Node level = root;
        Node current;

        while(level.left != null) {
            current = level;
            while(current != null) {
                current.left.next = current.right;

                if(current.next != null)
                    current.right.next = current.next.left;

                current = current.next;
            }

            level = level.left;
        }

        return root;
    }

    // Level order traversal
    // TC : O(n)
    // SC : O(n/2) = O(n)
    public Node connectQueue(Node root) {
        if(root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            Node current = queue.poll();

            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);

            for(int i=1; i < size; i++) {
                Node temp = queue.poll();
                current.next = temp;
                current = temp;

                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
        }

        return root;
    }
}
