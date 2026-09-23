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

//Approach: Using BFS with a queue, control the sibling and cousin pointer initialization.
//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                if (curr.left != null) {
                    // Assingn left child's next pointer to right
                    curr.left.next = curr.right;
                    // If sibling node is present, then assign right child's next pointer to sibling's left child
                    if (curr.next != null && curr.next.left != null) {
                        curr.right.next = curr.next.left;
                    }
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
        }

        return root;

    }
}