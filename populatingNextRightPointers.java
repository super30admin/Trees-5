/*
Problem: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

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

// Approach 1: BFS
// TC: O(n)
// SC: O(n)
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                
                if (i == size - 1) {
                    cur.next = null;
                } else {
                    cur.next = queue.peek();
                }
            }
        }
        
        return root;
    }
}

// Approach 2: 2 pointers - most efficient
// level pointer - travels across levels
// Cur pointer - travels within a level
// TC: O(n)
// SC: O(1)
class Solution {
    Node level, cur;
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        level = root; cur = null;
        
        // check for level.left != null because we operate on cur.left and right, and we shouldn't get null pointer exception
        while (level.left != null) {
            cur = level;
            
            while (cur != null) {
                cur.left.next = cur.right;
                cur.right.next = (cur.next == null ? null : cur.next.left);
                cur = cur.next;
            }
            level = level.left;
        }
        
        return root;
    }
}