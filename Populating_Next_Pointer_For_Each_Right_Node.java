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
//BFS approach
//tc: O(n)
//sc:O(n/2) = O(n)

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (i != size - 1) {
                    curr.next = q.peek();
                }
                if (curr.left != null) // dont check for right, as its perfect BT
                {
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        return root;
    }
}

// same approach as above, diff way of coding
/*
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public Node left;
 * public Node right;
 * public Node next;
 * 
 * public Node() {}
 * 
 * public Node(int _val) {
 * val = _val;
 * }
 * 
 * public Node(int _val, Node _left, Node _right, Node _next) {
 * val = _val;
 * left = _left;
 * right = _right;
 * next = _next;
 * }
 * };
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
                // curr.left.next = curr.right; //for right side when curr moves to next node
            }
            level = level.left;
        }
        return root;
    }
}

// DFS approach
/**
 * tc: O(n)
 * sc:O(h)
 */

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

        helper(root);
        return root;
    }

    private void helper(Node root) {
        if (root.left == null)
            return;

        // preorder scenario to add next pointer
        if (root.left != null)
            root.left.next = root.right;

        if (root.next != null) {
            root.right.next = root.next.left;
        }

        helper(root.left);
        helper(root.right);
    }
}

/*
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public Node left;
 * public Node right;
 * public Node next;
 * 
 * public Node() {}
 * 
 * public Node(int _val) {
 * val = _val;
 * }
 * 
 * public Node(int _val, Node _left, Node _right, Node _next) {
 * val = _val;
 * left = _left;
 * right = _right;
 * next = _next;
 * }
 * };
 */

// tc:O(n)
// sc:o(h)
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

        helper(root.left, root.right);
        return root;
    }

    private void helper(Node left, Node right) {
        if (left == null)
            return;

        left.next = right;

        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }
}