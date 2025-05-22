import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRtPointers {

    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (i != size - 1)
                    curr.next = q.peek();

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return root;
    }
}

//TC: O(n), SC: O(n/2);

//Approach - 2
/*
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
*/

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Node level = root;

        while (level.left != null) {
            Node curr = level;
            while (curr != null) {
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
}

//TC: O(n), SC: O(1);

//Approach - 3 : DFS
/*
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
*/

class DFSSolution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        dfs(root);

        return root;
    }

    private void dfs(Node curr) {
        if (curr.left == null)
            return;

        curr.left.next = curr.right;
        if (curr.next != null) {
            curr.right.next = curr.next.left;
        }

        dfs(curr.left);
        dfs(curr.right);
    }

}

//TC: O(n), SC: O(h)