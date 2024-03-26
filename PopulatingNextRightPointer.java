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
        // return helperBfs(root);
        // return helperDfs(root);
        return helperBfsOptimized(root);
    }

    // TC: O(n)
    // SC: O((n+1_/2) ~ O(n)
    private Node helperBfs(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node rightNode = null;
            for (int i = q.size(); i > 0; i--) {
                Node cur = q.poll();
                cur.next = rightNode;
                rightNode = cur;
                if (cur.right != null) {
                    q.offer(cur.right);
                    q.offer(cur.left);
                }
            }
        }
        return root;
    }

    // TC: O(n)
    // SC: O(logn)
    private Node helperDfs(Node root) {
        if (root == null)
            return null;
        Node left = root.left, right = root.right, next = root.next;
        if (left != null) {
            left.next = right;
            if (next != null)
                right.next = next.left;
            helperDfs(left);
            helperDfs(right);
        }
        return root;
    }

    // TC: O(n)
    // SC: O(1)
    private Node helperBfsOptimized(Node root) {
      Node head = root;
        for(; root != null; root = root.left) 
            for(Node cur = root; cur != null; cur = cur.next) 
                if(cur.left != null) {
                    cur.left.next = cur.right;
                    if(cur.next != null) cur.right.next = cur.next.left;
                } else break;
        
        return head;
    }
}