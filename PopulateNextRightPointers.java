// BFS O(n) time, O(n) space
// class Solution {
//     public Node connect(Node root) {
//         Queue<Node> q = new LinkedList<>();
//         if (root == null) return null;
//         q.offer(root);
//         while (!q.isEmpty()) {
//             int size = q.size();
//             for (int i = 0; i < size; i++) {
//                 Node curr = q.poll();
//                 if (i < size - 1) {
//                     curr.next = q.peek(); // next node will always be at front of q
//                 }
//                 if (curr.left != null) q.offer(curr.left);
//                 if (curr.right != null) q.offer(curr.right);
//             }
//         }
//         return root;
//     }  
// }

// O(n) time, O(1) space, rec stack space ignored for this question
class Solution {
    public Node connect(Node root) {
        return helper(root, null);
    }
    public Node helper(Node root, Node next) {
        if (root == null) return null;

        root.next = next;
        helper(root.left, root.right);
        helper(root.right, root.next == null ? null : root.next.left);
        return root;
    }
}

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
